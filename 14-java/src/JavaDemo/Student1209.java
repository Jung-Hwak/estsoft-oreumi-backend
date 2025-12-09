package JavaDemo;

public class Student1209 {
    private int id;
    private String name;

    public Student1209(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) { this.name = name; }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getName() { return  name; }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name;
    }
}