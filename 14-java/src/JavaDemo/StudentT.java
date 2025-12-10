package JavaDemo;

/**
 * 학생을 표현하는 클래스
 * → Student 클래스의 인스턴스들을 정렬하기 위해서는 인스턴스들은 비교할 수 있어야 한다.
 *   따라서 Student 클래스는 Comparable 인터페이스를 구현해서 compareTo 메서드를
 *   재정의해야 한다.
 *   이떼, Comparable 인터페이스에 타입 매개 변수로 Student 클래스를 지정한다.
 */
public class StudentT implements Comparable<StudentT> {
    private String id;
    private String name;

    public StudentT(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentT() { this(null, null); }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public String getName() { return name; }

    // toString 메서드 재정의
    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s", id, name);
    }

    // compareTo 메서드 재정의
    @Override
    public int compareTo(StudentT obj) {
        // return Integer.parseInt(id) - Integer.parseInt(obj.id);
        return id.compareTo(obj.id);
    }
}