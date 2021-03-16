package backend.externalservices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HibernateDB<V> implements DataStoreInterface<V>{
    SessionFactory sessionFactory;

    public HibernateDB() {
        this.sessionFactory=setUpFactory();

    }
    public HibernateDB(boolean test) {
        if (test) {
            this.sessionFactory = setUpTestFactory();
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

    public ArrayList search(String query, String table, String attribute ){
        Session session = getSession();

        String hqlQuery = "from "+table+ " where "+attribute+" =:query";
        List result = session.createQuery(hqlQuery)
                .setParameter("query",query).list();

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





}