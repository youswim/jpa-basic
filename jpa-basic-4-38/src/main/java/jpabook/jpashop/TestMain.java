package jpabook.jpashop;

public class TestMain {

    public static void main(String[] args) {

        Integer a = 10;
        Integer b = a;

        a = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
