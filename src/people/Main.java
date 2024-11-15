package people;

import people.dao.StudentDAO;
import people.model.Student;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        student.setFirstName("Mugabe");
        student.setLastName("Promesse");
        student.setDateOfBirth(LocalDate.parse("2000-12-10"));
        student.setSchool("Rwanda Coding Academy");
        student.setCombination("SPE");
        student.setLevel("y2");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.saveStudent(student);

        System.out.println(student.getFirstName()+ "is saved with id: " + student.getId());

    }
}