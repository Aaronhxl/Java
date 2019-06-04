package zju.cst.hl.JVM.Study_0522;

/**
 * 对比加final关键字与不加final关键字的区别：
 *
 *  分析：
 *      常量：final修饰，常量在编译阶段会存入到调用这个常量的方法所在的类的
 * 	    常量池中，本质上，调用类并没有直接引用到定义常量的类，因此并
 * 	    不会触发定义常量的类的初始化
 *
 * 	    这里实际上编译期间就已经把str的值存放到了Study_0522的常量池中，之后就和
 * 	     MyParent2没有任何关系了，甚至可以将MyParent2的class文件删除，对结果也不会影响
 *
 *      其他:Byte会导致MyParent2初始化,应该是引用类型，在编译的时候并不能确定，需要通过构造函数之类，才导致初始化
 *
 */
public class Study_0522 {
    public static void main(String[] args) {
        //System.out.println(MyParent2.str);
        System.out.println(MyParent2.str1);
        //System.out.println(MyParent2.i_c);
        System.out.println(MyParent2.i_s);
        System.out.println(MyParent2.i_i);
        System.out.println(MyParent2.i_l);
    }
}

class MyParent2{
    //public static String str = "hello world!";
    public static final String str1 = "hello world!";

   // public static final Byte i_c = 6;
    public static final short i_s = 6;
    public static final int i_i = 6;
    public static final long i_l= 6L;

    static {
        System.out.println("MyParent2 static block");
    }
}