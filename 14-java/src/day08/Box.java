package day08;

import javax.management.DescriptorKey;

public class Box<T> {
    // 필드(fields)
    private T data;

    // 메서드(methods)
    public Box(T data) { this.data = data; }
    public Box() { this(null); }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    // toString 메서드 재정의(method overriding)
    @Override
    public String toString() { return data.toString(); }
}

// 제네릭 클래스의 참조 변수를 선언하고나 인스턴스를 생략하면,
// 타입 매개 변수(type parameters)에 전달된 자료형을 이용해 Box<String> 클래스를 생성한다
/*
public class Box<String> {
    // 필드(fields)
    private String data;

    // 메서드(methods)
    public Box(String data) { this.data = data; }
    public Box() { this(null); }

    public String getData() { return data; }
    public void setData(T data) { this.data = data; }

    // toString 메서드 재정의(method overriding)
    @Override
    public String toString() { return data.toString(); }
 */