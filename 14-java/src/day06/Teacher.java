package day06;

public class Teacher extends Person {
    private int id;
    private String subject;

    public Teacher(String name, int age, Gender gender, String subject) {
        super(name, age, gender);

        setId(id);
        this.subject = subject;
    }

    public Teacher() { this(null, 0, null, null); }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) { this.subject = subject; }

    public int getId() { return id; }
    public String getSubject() { return subject; }

    @Override
    public void print() {
        super.print();

        System.out.println("Id: " + id);
        System.out.println("Subject: " + subject);
        System.out.println();
    }
}
