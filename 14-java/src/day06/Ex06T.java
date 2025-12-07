package day06;

import java.lang.classfile.PseudoInstruction;

public class Ex06T {
    static void main(String[] args) {
        // 객체 생성
        TeacherT potter =
                new TeacherT("Harry Potter", 37, Gender.MALE, 371, "Defence of the Dark");
        StudentT rose =
                new StudentT("Rose Granger-Weasley", 11, Gender.FEMALE, 7128,2,4.2);

        // 출력
        potter.print();
        rose.print();

        System.out.println("-------------------------------------------------------------------");

        // 슈퍼 클래스의 참조 변수로 서브 클래스의 인스턴스를 참조할 수 있다.
        PersonT personT = potter;

        // 슈퍼 클래스의 참조 변수로 서브 클래스의 인스턴스를 참조하는 경우,
        // 슈퍼 클래스의 참조 변수로 서브 클래스의 멤버에는 접근할 수 없다.
        // int id = presonT.gedId();                // ERROR!

        // 슈퍼 클래스의 참조 변수로 서브 클래스의 멤버에 접근하려면,
        // 슈퍼 클래스의 참조 변수로 서브 클래스로 형 변환해야 한다.
        // int id = ((TeacherT)personT).getId();

        //재정의한 메서드는 동적 바인딩(dynamic binding)을 한다.
        personT.print();          // Teacher#print();

        // 슈퍼 클래스의 잠조 변수로 서브 클래스의 인스턴스를 참조할 수 있다.
        personT = rose;

        personT.print();            // Student#print();

        System.out.println("--------------------------------------------------------------------");

        // Person 클래스의 객체 배열(object array) 생성
        PersonT[] list = new PersonT[2];

        // 슈퍼 클래스의 참조 변수로 서브 클래스의 인스턴스를 참조할 수 있다.
        list[0] = potter;
        list[1] = rose;

        // for-each 구문으로 객체 배열 list의 원소에 차례대로 접근
        for (PersonT item: list) {
            item.print();
        }
    }
}
