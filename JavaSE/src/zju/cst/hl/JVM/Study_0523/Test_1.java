package zju.cst.hl.JVM.Study_0523;

import java.util.UUID;

/**
 * 这个时候static的打印又会打印出来
 *  一个编译时就可以确定和只有运行时才可以确定的区别
 *  此时，str只有运行时才可以确定
 *
 *  总结：当一个常量并非确认时就能确定时，此时会导致初始化
 */
public class Test_1 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block");
    }
}