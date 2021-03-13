package externalservices;

import library.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HibernateUtils{
    SessionFactory sessionFactory;

    public HibernateUtils() {
        this.sessionFactory=setUpFactory();

    }

    private SessionFactory setUpFactory(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
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

    public ArrayList search(String query, String table, String attribute ){
        Session session = getSession();

        String hqlQuery = "from "+table+ " where "+attribute+" =:query";
        List result = session.createQuery(hqlQuery)
                .setParameter("query",query).list();

        stopSession(session);

        return new ArrayList<>(result);
    }

    public void allItems(){
        Session session = getSession();
        List result = session.createQuery("from User")
                .list();
        System.out.println("printing users");
        for ( User user : (List<User>) result ) {
            System.out.println( "User -" + user.getFullName());
        }
        stopSession(session);
    }


    public void addNewItem(Object item){
        Session session = getSession();
        session.save(item);
        stopSession(session);
    }

    public void updateItem(Object item){
        Session session = getSession();
        session.update(item);
        stopSession(session);
    }

    public void deleteItem(Object item){
        Session session = getSession();
        session.remove(item);
        stopSession(session);
    }





}