package zju.cst.hl.JVM.Study_0521;


import java.util.UUID;

/**
 * JVM学习--0521
 *
 * 知识点：对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 换句话说：例子1中，Myparent1才是主动使用，所以它初始化了
 *          而Mychild没有初始化
 *          例子2中，则主动的是MyChild，它继承了MyParent，所以
 *          MyParent也是主动使用，也会初始化
 *
 *  当一个类在初始化时，要求其父类全部都已经初始化完毕了
 *  类的初始化阶段会对static代码块进行执行
 */
public class Study_0521 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        //System.out.println(MyChild1.str2);
    }
}

class MyParent1{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("Myparent1 static block");
    }
}

class MyChild1 extends MyParent1{

    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}