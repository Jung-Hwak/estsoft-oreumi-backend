package day06;

public class TeacherT extends PersonT {
    // 필드(fields)
    private int id;
    private String subject;

    // 메서드(methods)
    public TeacherT(String name, int age, Gender gender, int id, String subject) {
        super(name, age, gender);

        setId(id);
        this.subject = subject;
    }

    public TeacherT() { this(null, 0, Gender.UNDISCLOSED, 0, null); }

    public void setId(int id) {
        // TODO: 올바른 ID인지 검사하고 나서 필드에 설정
        this.id = id;
    }

    public void setSubject(String subject) { this.subject = subject; }

    public int getId() { return id; }
    public String getSubject() { return subject; }

    // 슈퍼 클래스의 print 메서드를 재정의(overriding)
    @Override
    public void print() {
        super.print();

        System.out.println("ID: " + id);
        System.out.println("Subject: " + subject);
        System.out.println();
    }
}
