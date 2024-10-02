import app.oop.exercises.DatabaseManager;
import app.oop.exercises.Person;
import app.oop.exercises.Student;
import java.sql.DriverManager;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter date of birth in yyyy-mm-dd format: ");
        String dob = scanner.next();
        Date dateOfBirth = Date.valueOf(dob);


        System.out.print("Enter your school name: ");
        String school = scanner.next();

        System.out.print("Enter your combination: ");
        String combination = scanner.next();

        System.out.print("Enter your level: ");
        String level = scanner.nextLine();

        Student student = new Student(firstName, lastName, dateOfBirth, school, combination, level);

        DatabaseManager dbManager = new DatabaseManager();
        dbManager.insertStudent(student);
    }
}