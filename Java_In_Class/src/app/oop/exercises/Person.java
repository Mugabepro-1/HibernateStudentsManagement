package app.oop.exercises;

public class Person {
    private int id;
    protected String firstName;
    protected String lastName;
    private int age;
    //Default constructor
    public Person(){

    }
    public Person(int id, String firstName, String lastName, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age= age;
    }
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age= age;
    }
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(int age){
        this.age = age;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void print(){
        System.out.println("I am a person");
    }
    public String print(String name, int number){
        return "I am "+name+" "+number;
    }
    public void print(String tilte){
        System.out.println("I am "+ tilte);
    }
    @Override
    public String toString(){
        return "Person Id is "+this.id+"I am "+ this.firstName+" "+ this.lastName+ "My age is "+this.age;
    }
}
