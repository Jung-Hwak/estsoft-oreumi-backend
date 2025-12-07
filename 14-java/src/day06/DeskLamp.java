package day06;

public class DeskLamp {
    private boolean isOn;

    // 메서드(methods)
    public DeskLamp(boolean isOn) { this.isOn = isOn; }
    public DeskLamp() { this(false); }

    public void turnOn () { this.isOn = true; }
    public void turnOff() { this.isOn = false; }

    public void printStatus () {
        System.out.println("Status: " + (isOn ? "ON" : "OFF"));
    }
}
