package zju.cst.hl.JVM.Study_0527;

import java.util.Random;

/**
 * 接口其实和类一样，关注一点，接口中的变量默认是public static final
 */
public class Test_1 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5{
    public static final int a = new Random().nextInt(10);//public static final是多余的，因为在接口中的变量默认为public static
}

interface MyChild5 extends MyParent5{
    public static final int b = 5;
}