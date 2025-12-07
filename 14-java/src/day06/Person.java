package day06;

public class Person {
    private String name;
    private int age;
    private Gender gender;

    // 메서드(methods)
    public Person(String name, int age, Gender gender) {
        this.name = name;
        SetAge(age);
        this.gender = gender;
    }

    public Person() { this(null, 0, Gender.UNDISCLOSED); }

    public void SetName(String name) { this.name = name; }
    public void SetAge(int age) { this.age = Math.max(age, 0); }
    public void SetGender(Gender gender) { this.gender = gender; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Gender getGender() { return gender; }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
