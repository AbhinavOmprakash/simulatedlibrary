package externalservices;

import models.dataobjects.library.Member;
import models.dataobjects.library.membershiplevels.MembershipLevel;
import models.dataobjects.library.membershiplevels.MembershipPolicy;
import models.dataobjects.libraryitems.AudioBook;
import models.dataobjects.libraryitems.Book;
import models.dataobjects.libraryitems.LibraryItem;
import models.dataobjects.libraryitems.contributors.Author;
import models.dataobjects.libraryitems.contributors.Contributor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class HibernateDB<V> implements DataStoreInterface<V>{
    SessionFactory sessionFactory;
    private static HibernateDB uniqueInstance;
    private static HibernateDB testUniqueInstance;

    public static HibernateDB getInstance(){
        if (uniqueInstance==null){
            uniqueInstance = new HibernateDB();
        }
        return uniqueInstance;
    }
    public static HibernateDB getTestInstance(){
        if (testUniqueInstance==null){
            testUniqueInstance = new HibernateDB(true);
        }
        return testUniqueInstance;
    }

    private HibernateDB() {
        this.sessionFactory=setUpFactory();

    }
    private HibernateDB(boolean test) {
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

    public ArrayList search(Object query, String table, String attribute ){
        Session session = getSession();

        String hqlQuery = "from "+table+ " where "+attribute+" =:query";
        List result = session.createQuery(hqlQuery)
                .setParameter("query",query).list();

        stopSession(session);

        return new ArrayList<>(result);
    }

    public ArrayList fetchAll(String table){
        Session session = getSession();

        String hqlQuery = "from "+table;
        List result = session.createQuery(hqlQuery).list();

        stopSession(session);
        return new ArrayList<>(result);
    }

    public void addNewItem(V item){
        Session session = getSession();
        session.save(item);
        stopSession(session);
    }

    public void updateItem(V item){
        Session session = getSession();
        session.update(item);
        stopSession(session);
    }

    public void deleteItem(V item){
        Session session = getSession();
        session.remove(item);
        stopSession(session);
    }

    private void createTestObjects(){
        // objects created for trial runs and testing etc.

        // book 1
        Contributor writer1 = new Author("John Green");
        Contributor writer2 = new Author("David Levithan");
        ArrayList<Contributor> contributors1 = new ArrayList<>(Arrays.asList(writer1, writer2));
        LibraryItem book1 = new Book("Will Greyson,Will Greyson",
                "YA",
                123456789,
                contributors1,
                true,
                999999999);

        addNewItem((V) writer1);
        addNewItem((V) writer2);
        addNewItem((V) book1);

        // audio book 1
        LibraryItem audioBook1 = new AudioBook("Will Greyson,Will Greyson",
                "YA",
                123456789,
                contributors1,
                true,
                999999999);

        // audio book 2
        ArrayList<Contributor> contributor2 = new ArrayList<>(Collections.singletonList(writer1));
        LibraryItem audioBook2 = new AudioBook("The fault in our stars",
                "Yound Adult, Romance",
                13427890,
                contributor2,
                true,
                91234821);

        addNewItem((V) audioBook1);
        addNewItem((V) audioBook2);

        MembershipPolicy basicPolicy = new MembershipPolicy("Basic",10.0,
                1.0 ,1,
                0.0, 12);

        addNewItem((V) basicPolicy);
        Member user = new Member("Abhinav", "Omprakash", "abhi", new MembershipLevel(basicPolicy));
        addNewItem((V) user);
    }



}