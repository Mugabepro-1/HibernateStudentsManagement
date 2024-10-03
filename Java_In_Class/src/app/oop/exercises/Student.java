package app.oop.exercises;

public class Student extends Person{
    private String school;
    private String combination;
    private String level;
    public Student() {

    }



    public Student(int id, String firstName, String lastName, int age, String combination, String school, String level){
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
        super(id, firstName, lastName, age);
        this.combination = combination;
        this.school = school;
        this.level = level;

    }
    public void print(){
        System.out.println("I am a student");
        super.print();
    }
    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", combination='" + combination + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
