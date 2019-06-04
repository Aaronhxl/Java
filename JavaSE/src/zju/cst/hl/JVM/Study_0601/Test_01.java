package zju.cst.hl.JVM.Study_0601;

/**
 * final关键字
 */
public class Test_01 {
    public static void main(String[] args) {
        System.out.println(MyTest.b);
    }
}

class MyTest{
    public static final int b = 3;
    static {
        System.out.println("MyTest static block");
    }
}
