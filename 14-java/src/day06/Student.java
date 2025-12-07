package day06;

public class Student extends Person {
    private int id;
    private int year;
    private double gpa;

    public Student(String name, int age, Gender gender, int id, int year, double gpa) {
        super(name, age, gender);

        setId(id);
        setYear(year);
        setGpa(gpa);
    }

    public Student() { this(null, 0, Gender.UNDISCLOSED, 0, 0, 0); }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year >= 1 && year <= 7 ? year : 0;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa >= 0 && gpa <= 4.5 ? gpa : 0;
    }

    public int getId() { return id; }
    public int getYear() { return year; }
    public double getGpa() { return gpa; }

    @Override
    public void print() {
        super.print();

        System.out.println("ID: " + id);
        System.out.println("Year: " + year);
        System.out.println("GPA: " + gpa);
        System.out.println();
    }
}
