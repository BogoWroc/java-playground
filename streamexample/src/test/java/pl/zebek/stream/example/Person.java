package pl.zebek.stream.example;

/**
 * Created by Bogumil Zebek on 28.03.18.
 */
public class Person {
    private final String name;
    private final int age;
    private final String nationality;

    public Person(String name, int age) {
        this(name, age, "Polish");
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
