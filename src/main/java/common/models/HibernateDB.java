package common.models;

import admin.models.Admin;
import library.models.BorrowedItem;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import library.models.libraryitems.AudioBook;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import login.models.LoginData;
import login.models.RawLoginData;
import signup.models.CredentialCreator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class HibernateDB implements DataStoreInterface{
    SessionFactory sessionFactory;
    public HibernateDB() {
        this.sessionFactory = setUpFactory();
    }

    public HibernateDB(boolean test) {
        if (test) {
            this.sessionFactory = setUpTestFactory();
            createTestObjects();

        } else{
            this.sessionFactory=setUpFactory();
        }
    }

    private SessionFactory setUpFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernateTEST.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            System.out.println("we got a problem "+e.toString());
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }
    private SessionFactory setUpTestFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernateTEST.cfg.xml") // configures settings from hibernateTEST.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            System.out.println("we got a problem "+e.toString());
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }
    public Session getSession(){
        if (sessionFactory==null){
            sessionFactory=setUpFactory();
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void stopSession(Session openSession){
        openSession.getTransaction().commit();
        openSession.close();
    }

    @Override
    public Object search(Object query, Object itemType, String attribute) {
        Session session = getSession();

        String hqlQuery = "from "+itemType+ " where "+attribute+" =:query";
        Object result = session.createQuery(hqlQuery)
                .setParameter("query",query).uniqueResult();
        stopSession(session);

        return result;
    }

    @Override
    public ArrayList<Object> fuzzySearch(Object query, Object itemType, String attribute) {
        Session session = getSession();

        String hqlQuery = "from "+itemType+ " where "+attribute+" =:query";
        List result = session.createQuery(hqlQuery)
                .setParameter("query",query).list();
        stopSession(session);

        return new ArrayList<>(result);
    }

    @Override
    public void updateItem(Object item, Object itemType) {
        Session session = getSession();
        session.update(item);
        stopSession(session);
    }

    @Override
    public void addNewItem(Object item, Object itemType) {
        Session session = getSession();
        session.save(item);
        stopSession(session);
    }

    @Override
    public void deleteItem(Object item, Object itemType) {
        Session session = getSession();
        session.remove(item);
        stopSession(session);
    }

    @Override
    public ArrayList<Object> fetchAll(Object itemType) {
        Session session = getSession();
        String hqlQuery = "from "+ itemType;
        List result = session.createQuery(hqlQuery).list();

        stopSession(session);
        return new ArrayList<>(result);
    }
    private void createTestObjects(){
        // objects created for trial runs and testing etc.

        // book 1
        Contributor JohnGreen = new Author("John Green");
        Contributor DavidLevithan = new Author("David Levithan");
        ArrayList<Contributor> willGreysonContribs = new ArrayList<>(Arrays.asList(JohnGreen, DavidLevithan));
        LibraryItem book1 = new Book("Will Greyson,Will Greyson",
                "YA",
                123456789,
                true,
                999999999);

        book1.setContributors(willGreysonContribs);

        addNewItem(JohnGreen, Author.class);
        addNewItem(DavidLevithan, Author.class);
        addNewItem(book1, LibraryItem.class);

        // audio book 1
        LibraryItem audioBook1 = new AudioBook("Will Greyson,Will Greyson",
                "YA",
                123456789,
                true,
                999999999);
        audioBook1.setContributors(willGreysonContribs);

        // audio book 2
        ArrayList<Contributor> tfiosContribs = new ArrayList<>(Collections.singletonList(JohnGreen));
        LibraryItem audioBook2 = new AudioBook("The fault in our stars",
                "Young Adult, Romance",
                13427890,
                true,
                91234821);
        audioBook2.setContributors(tfiosContribs);

        addNewItem(audioBook1, LibraryItem.class);
        addNewItem(audioBook2, LibraryItem.class);

        MembershipPolicy basicPolicy = new MembershipPolicy("Basic",10.0,
                1.0 ,1,
                0.0, 12);

        MembershipPolicy goldPolicy = new MembershipPolicy("Gold",100.0,
                0.005 ,3,
                0.0, 12);
        addNewItem(basicPolicy, MembershipPolicy.class);
        addNewItem(goldPolicy, MembershipPolicy.class);

        Member abhinav = new Member("Abhinav", "Omprakash", "ab", new MembershipLevel(basicPolicy));
        RawLoginData rawAbhiLogin = new RawLoginData("ab","aww");
        LoginData abhiLogin=CredentialCreator.createNewCredential(rawAbhiLogin);
        FinancialAccount abhinavAccount = new FinancialAccount(abhinav.getUserName());

        Member goldUser = new Member("goldie", "glitters", "au", new MembershipLevel(goldPolicy));
        RawLoginData rawGoldLogin = new RawLoginData("au","aww");
        LoginData goldLogin=CredentialCreator.createNewCredential(rawGoldLogin);
        FinancialAccount goldAccount = new FinancialAccount(goldUser.getUserName());

        Member delayedUser = new Member("lazy", "larry", "la", new MembershipLevel(basicPolicy));
        RawLoginData rawDelayedLogin = new RawLoginData("la","aww");
        LoginData delayedLogin =CredentialCreator.createNewCredential(rawDelayedLogin);
        FinancialAccount delayedUserAccount = new FinancialAccount(delayedUser.getUserName());

        Admin administrator = new Admin("Deepak", "Yadav", "admin");
        RawLoginData rawAdminLogin = new RawLoginData("admin","JavaSucks");
        LoginData adminLogin = CredentialCreator.createNewCredential(rawAdminLogin);

        addNewItem(abhinav, User.class);
        addNewItem(abhiLogin, LoginData.class);
        addNewItem(abhinavAccount, FinancialAccount.class);

        addNewItem(goldUser, User.class);
        addNewItem(goldLogin, LoginData.class );
        addNewItem(goldAccount, FinancialAccount.class);

        addNewItem(delayedUser, User.class);
        addNewItem(delayedLogin, LoginData.class );
        addNewItem(delayedUserAccount, FinancialAccount.class);

        addNewItem(administrator, User.class);
        addNewItem(adminLogin, LoginData.class);

        //creating overdue item for testing.
        LibraryItem lookingForAlaska = new Book("looking for alaska",
                                        "YA",
                                        123456789,
                                        true,
                                        999999999);

        lookingForAlaska.setContributors(willGreysonContribs);

        addNewItem(lookingForAlaska, LibraryItem.class);

        delayedUser.borrowItem(lookingForAlaska);
        updateItem(delayedUser, User.class);

        BorrowedItem overdueBook = new BorrowedItem(lookingForAlaska);
        LocalDateTime overdue = LocalDateTime.of(1985, 10, 25, 16, 1);
        overdueBook.setBorrowedOn(overdue);

        addNewItem(overdueBook, BorrowedItem.class);
    }

}