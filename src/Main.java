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

        System.out.println("Enter first name: ");
        String firstName = scanner.next();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter date of birth in yyyy-mm-dd format: ");
        String dob = scanner.nextLine();
        Date dateOfBirth = Date.valueOf(dob);


        System.out.println("Enter your school name: ");
        String school = scanner.nextLine();

        System.out.println("Enter your combination: ");
        String combination = scanner.nextLine();

        System.out.println("Enter your level: ");
        String level = scanner.nextLine();

        Student student = new Student(firstName, lastName, dateOfBirth, school, combination, level);

        DatabaseManager dbManager = new DatabaseManager();
        dbManager.insertStudent(student);
    }
}