package day06;

import java.net.SocketTimeoutException;

public class PersonT {
    // 필드(fields)
    private String name;
    private int age;
    private Gender gender;

    // 메서드(methods)
    public PersonT(String name, int age, Gender gender) {
        this.name = name;
        setAge(age);
        this.gender = gender;
    }

    public PersonT() { this(null, 0, Gender.UNDISCLOSED); }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = Math.max(age, 0); }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Gender getGender() { return gender; }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
