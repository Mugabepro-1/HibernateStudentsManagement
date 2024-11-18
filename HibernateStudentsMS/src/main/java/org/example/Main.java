package org.example;

import org.example.model.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Create a new student
        Student student = new Student();
        student.setFirstName("Mugabe");
        student.setLastName("Promesse");
        student.setDateOfBirth("2000-01-01");
        student.setSchool("RCA");
        student.setCombination("SPE");
        student.setLevel("Y2");

        // Save the student using Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("Student saved successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}
