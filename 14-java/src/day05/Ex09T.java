package day05;

public class Ex09T {
    public static void main(String[] args) {
        // 객체 생성
        StudentT kim = new StudentT("Cheolsu Kim", 88, 76, 64);
        StudentT park = new StudentT("Yeonghee Park", 92, 88, 94);
        StudentT hong = new StudentT("Gildon Hong", 96, 64, 48);

        // 출력
        kim.print();
        park.print();
        hong.print();
    }
}
