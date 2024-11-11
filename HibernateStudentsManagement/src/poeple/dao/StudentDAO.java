package poeple.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import poeple.model.Student;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO(){
        SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    }
    public void saveStudent(Student student){
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
