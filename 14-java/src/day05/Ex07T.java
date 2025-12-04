package day05;

public class Ex07T {
    public static void main(String[] args) {
        // 객체 생성
        PersonT jackson = new PersonT();
        PersonT carey = new PersonT();
        PersonT dean = new PersonT();

        // 설정자로 객체에 값을 설정
        jackson.setName("Michael Jackson");
        jackson.setAge(24);

        carey.setName("Mariah Carey");
        carey.setAge(21);

        dean.setName("James Dean");
        dean.setAge(36);

        // 각 객체의 preint 메서드로 출력
        jackson.print();
        carey.print();
        dean.print();
    }
}
