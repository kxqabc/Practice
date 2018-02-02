package miles.test;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class A{
    double weight = 2.0;

    {
        weight = 2.1;
        System.out.println("我是代码块");
    }

    public A() {
        System.out.println("我是构造函数");
    }
    static{
        System.out.println("我是静态代码块");
    }
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.weight);
    }
}