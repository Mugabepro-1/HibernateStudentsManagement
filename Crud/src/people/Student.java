package people;

import java.sql.Date;

public class Student extends Person {
    private String school;
    private String combination;
    private String level;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, Date dateOfBirth, String school, String combination, String level) {
        super(id, firstName, lastName, dateOfBirth);
        this.combination = combination;
        this.school = school;
        this.level = level;
    }

    public Student(String firstName, String lastName, Date dateOfBirth, String school, String combination, String level) {
        super(firstName, lastName, dateOfBirth);
        this.school = school;
        this.combination = combination;
        this.level = level;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public String getCombination() {
        return this.combination;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return this.level;
    }

    public void print() {
        System.out.println("I am a student");
        super.print();
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", combination='" + combination + '\'' +
                ", level='" + level + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
