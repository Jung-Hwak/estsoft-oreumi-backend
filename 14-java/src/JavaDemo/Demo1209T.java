package JavaDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo1209T {
    public static void main(String[] args) {
        // ArrayList 클래스의 인스턴스 생성
        List<StudentT> students = new ArrayList<>();

        // students 객체에 Student 클래스의 인스턴스를 추가
        students.add(new StudentT("20255108", "James"));
        students.add(new StudentT("20255114", "Michael"));
        students.add(new StudentT("20255103", "Hans"));

        // 리스트 students를 출력
        System.out.println(students);

        // java.util.Collections 클래스의 sort 메서드로 리스트를 오름차순으로 정렬
        Collections.sort(students);

        // 리스트 students를 출력
        System.out.println(students);

        // java.util.Collections 클래스의 sort 메서드로 리스트를 내림차순으로 정렬
        // → 내림차순으로 정렬하기 위해 sort 메서드의 두 번째 인자로 Collections 클래스의
        //   reverseOrder 메서드를 지정한다.
        // Collections.sort(students, Collections.reverseOrder());

        // List 인터페이스의 sort 메서드로 리스트를 내림차순으로 정렬
        students.sort(Collections.reverseOrder());

        // 리스트 students를 출력
        System.out.println(students);
        System.out.println();

        // for-each 구문으로 리스트 students의 요소를 하나씩 출력
        for (StudentT studentT : students) {
            System.out.println(studentT);
        }

        System.out.println();

        // 리스트의 sort 메서드와 람다 표현식으로 리스트 students를 내림차순으로 정렬
        students.sort((a, b) -> b.getId().compareTo(a.getId()));

        // Collection 인터페이스의 forEach 메서드로 리스트 students의 요소를 하나씩 출력
        // → "System.out::println"은 메서드 레퍼런스(method reference)라고 한다.
        //   메서드 레퍼런스는 람다 표현식의 또다른 형태이다.
        students.forEach(System.out::println);
    }
}