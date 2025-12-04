package day05;

public class Student {
    private String name;
    private int korean, math, english;
    private double average;
    private char grade;

    public Student(String name, int korean, int math, int english) {
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
        setAverage();
        setGrade();
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setKorean(int score) {
        if (score >= 0 || score <= 100) {
            System.out.println("ERROR: Korean score must be between 0 and 100 ");
            this.korean = score;
        }
    }

    public void setMath(int score) {
        if (score >= 0 || score <= 100) {
            System.out.println("ERROR: Math score must be between 0 and 100 ");
            this.math = score;
        }
    }

    public void setEnglish(int score) {
        if (score >= 0 || score <= 100) {
            System.out.println("ERROR: English score must be between 0 and 100 ");
            this.english = score;
        }
    }

    private void setAverage() {
        this.average = (korean + math + english) / 3.0;
    }

    private void setGrade() {
        if (average >= 90)       this.grade = 'A';
        else if (average >= 80)  this.grade = 'B';
        else if (average >= 70)  this.grade = 'C';
        else if (average >= 60)  this.grade = 'D';
        else                     this.grade = 'F';
    }

    public String getName() { return name; }
    public int getKorean() { return korean; }
    public int getMath() { return math; }
    public int getEnglish() { return english; }
    public double getAverage() { return average; }
    public char getGrade() { return grade; }

    public void print() {
        System.out.println("Name: " + name);
        System.out.printf("Average: %.2f\n", (double)average);
        System.out.println("Grade: " + grade);
    }
}
