package zju.cst.hl.JVM.Study_0601;

/**
 * 静态方法和静态变量类似，只有定义了该静态方法才是主动使用
 */
public class Test_04 {
    public static void main(String[] args) {
        System.out.println(Child4.a);
        Child4.doSomeThing();
    }
}

class Parent4{
    static final int a = 2;
    static {
        System.out.println("Parent4 static block");
    }

    static void doSomeThing(){
        System.out.println("doSomeThing");
    }
}

class Child4 extends Parent4{
    static int b =1;
    static {
        System.out.println("Child4 static block");
    }
}