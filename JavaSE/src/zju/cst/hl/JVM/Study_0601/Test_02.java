package zju.cst.hl.JVM.Study_0601;

public class Test_02 {

    static {
        System.out.println("Test_02 static block");
    }
    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}

class Parent{
    static int a = 5;
    static {
        System.out.println("Parent static block");
    }
}


class Child extends Parent{
    static int b = 3;
    static {
        System.out.println("Child static block");
    }
}
