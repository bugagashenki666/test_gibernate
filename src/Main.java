import enums.Days;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory =null;
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            if(registry !=null)StandardServiceRegistryBuilder.destroy( registry );
            System.out.println("Exception");
            System.out.println(e.getMessage());
            return;
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Student("Maxim 2", new Date(81, 11, 29), Days.MONDAY));
        session.save(new Student("Vladimir 3", new Date(81, 11, 29), Days.SATURDAY));
        session.getTransaction().commit();
        session.close();
    }
}
