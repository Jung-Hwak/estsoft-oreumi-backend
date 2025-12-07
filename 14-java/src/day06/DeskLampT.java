package day06;

public class DeskLampT {
    // 필드(fields)
    private boolean isOn;

    // 메서드(methods)
    public DeskLampT(boolean isOn) { this.isOn = isOn; }
    public DeskLampT() { this(false); }

    public DeskLampT turnOn () {
        this.isOn = true;
        return this;
    }
    public DeskLampT turnOff() {
        this.isOn = false;
        return this;
    }

    public void printStatus () {
        System.out.println("Status: " + (isOn ? "ON" : "OFF"));
    }
}
