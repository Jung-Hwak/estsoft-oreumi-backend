package JavaDemo;

import java.util.ArrayList;
import java.util.Comparator;

public class Demo1209 {
    public static void main(String[] args) {
        Student1209 s1 = new Student1209(20255108, "James");
        Student1209 s2 = new Student1209(20255114, "Michael");
        Student1209 s3 = new Student1209(20255103, "Hans");

        ArrayList<Student1209> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.sort(new Comparator<Student1209>() {
            @Override
            public int compare(Student1209 a, Student1209 b) {
                return a.getName().compareTo(b.getName());
            }
        });

        for (Student1209 stu : list) {
            System.out.println(stu);
        }
    }
}
