package com.example.myboot.test;

public class TestOrder {
    // 静态变量

    public static TestA a = new TestA();

    private static String s;
    // 静态初始化块

    static {
        System.out.println("静态初始化块"+s);
    }

    // 静态变量

    public static TestB b = new TestB();



    public static void main(String[] args) {

        new TestOrder();
    }
}

class TestA {
    public TestA() {
        System.out.println("Test--A");
    }
}

class TestB {
    public TestB() {
        System.out.println("Test--B");
    }
}
