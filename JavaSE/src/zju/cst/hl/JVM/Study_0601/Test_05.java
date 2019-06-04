package zju.cst.hl.JVM.Study_0601;

import java.sql.SQLOutput;

/**
 * 这段代码的作用就是验证反射会导致类的初始化：
 *      也就是Class.forName这种情况
 *
 *      调用ClassLoader的loadClass方法并不是对类的主动使用，不会导致类的初始化
 *      顾名思义，loadclass只是加载类，并不是主动使用
 */
public class Test_05 {
    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = classLoader.loadClass("zju.cst.hl.JVM.Study_0601.CL");
        System.out.println(aClass);
        System.out.println("--------------");
        Class<?> aClass1 = Class.forName("zju.cst.hl.JVM.Study_0601.CL");
        System.out.println(aClass1);


    }
}

class CL{
    static {
        System.out.println("CL static block");
    }
}

