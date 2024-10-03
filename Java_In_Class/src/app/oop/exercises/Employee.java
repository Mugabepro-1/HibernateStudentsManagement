package app.oop.exercises;

public class Employee {
    private int id;
    private String firstName;
    protected String lastName;
    private int age;

    public Employee(int id, String firstName, int age, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
    }
    public Employee(){

    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
