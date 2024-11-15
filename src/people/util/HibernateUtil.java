package people.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import people.model.Student;

public class HibernateUtil {
    private static final SessionFactory factory;
    static{
        try{
            factory = new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory(){
        return factory;
    }
}
