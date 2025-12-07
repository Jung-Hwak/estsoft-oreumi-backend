package day06;

public class Ex01 {
    public static void main(String[] args) {
        DeskLamp myLamp = new DeskLamp();

        myLamp.turnOn();
        myLamp.printStatus();

        myLamp.turnOff();
        myLamp.printStatus();
    }
}
