package zju.cst.hl.JavaSE.study_0715;

/**
 * Package: zju.cst.hl.JavaSE.study_0715
 * Description： java8之后，接口中的允许有静态方法
 * Author: huanglong
 * Date: Created in 2019/7/15 15:21
 * Version: 0.0.1
 */

/**
 * java8中对接口的增强
 * 参考文章：https://blog.csdn.net/sun_promise/article/details/51220518
 */
public interface InterfaceMethod {

    int key = 1;

    /**
     * 接口中的静态方法
     */
    static void  method1(){
        System.out.println("interface static method");
    }

    /**
     * 默认方法
     */
    default void method2(){
        System.out.println("interface default method");
    }

    /**
     * 不可以重写Object类的方法、但是可以重载Object类的方法
     * @param a
     * @return
     */
    default String toString(String a){
        return null;
    }
}

interface A{
    default void sayHello(){
        System.out.println("hello from interface A");
    }
}

interface B extends A{
    @Override
    default void sayHello(){
        System.out.println("hello from interface B");
    }
}

class C implements B,A,InterfaceMethod{
    static void  method1(){
        System.out.println("interface static method");
    }

}