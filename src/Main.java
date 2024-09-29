import app.oop.exercises.Person;
import app.oop.exercises.Student;

public class Main{
    public static void main(String[] args){
        //Here we can use Object instead of person because Person class inherits from object class
        Object person1 = new Person(1, "Mary", "Hills", 12);
        System.out.println(person1.toString());
        Person p = new Person();
        Student student1 = new Student(1,"Mu", "Pro", 16, "SPE", "RCA", "12" );
    }
}