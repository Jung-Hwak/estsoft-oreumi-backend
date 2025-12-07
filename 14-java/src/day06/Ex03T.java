package day06;

public class Ex03T {
    public static void main(String[] args) {
        // 객체 생성
        DeskLampT lamp = new DeskLampT();

        // 책상 조명등을 켜고 상태를 출력
        lamp.turnOn().printStatus();

        // 책상 조명등을 끄고 상태를 출력
        lamp.turnOff().printStatus();
    }
}
