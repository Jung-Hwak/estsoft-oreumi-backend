package day05;

public class StudentT {
    // 필드(fields)
    private String name;
    private int korean;
    private int math;
    private int english;
    private double average;
    private char grade;

    // 메서드(methods)

    // 생성자(constructors)
    public StudentT(String name, int korean, int math, int english) {
        this.name = name;

        // 필드에 잘못된 값이 초기화되지 않도록 설정자를 사용해 초기화한다.
        // this.korean = korean;
        setKorean(korean);
        setMath(math);
        setEnglish(english);

        average = 0;
        grade = 'F';
    }

    public StudentT() {
        this(null,0,0,0);
    }

    // 설정자(setters)
    public void setName(String str) {
        this.name = str;
    }

    public void setKorean(int korean) {
        // if (score >= 0 && score <= 100) this.korean = score;
        // this.korean = korean >= 0 && korean <= 100 ? korean : 0;
        this.korean = isValidScore(korean) ? korean : 0;
    }

    public void setMath(int math) {
        this.math = isValidScore(math) ? math : 0;
    }

    public void setEnglish(int english) {
        this.english = isValidScore(english) ? english : 0;
    }



    /**
     *  유효한 점수인지 확인
     *
     * @param score 확인하고자 하는 점수
     * @return 유효한 점수인지 여부
     */
    private boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }
    // 접근자(getters)
    public String getName() { return name; }
    public int getKorean() { return korean; }
    public int getMath() { return math; }
    public int getEnglish() { return english; }
    public double getAverage() {
        average = (double)(average + math + english) / 3;
        return average;
    }
    public char getGrade() {
        // 등급을 구하기 위해 먼저 평균 점수부터 구한다.
        getAverage();
        if (average >= 90)       grade = 'A';
        else if (average >= 80)  grade = 'B';
        else if (average >= 70)  grade = 'C';
        else if (average >= 60)  grade = 'D';
        else                     grade = 'F';

        return grade;
    }

    // 출력
    public void print() {
        // 출력하기 전에 평균 점수와 등급을 먼저 구한다
        getGrade();

        System.out.println("Name: " + name);
        System.out.printf("Average: %.1f%n", average);
        System.out.println("Grade: " + grade);
        System.out.println();
    }

}
