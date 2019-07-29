package zju.cst.hl.JavaSE.Study_0620;

import java.io.IOException;

/**
 * Package: zju.cst.hl.JavaSE.Study_0620
 * Description： 函数override的时候，抛出的异常应该小于等于父类
 * Author: huanglong
 * Date: Created in 2019/6/20 23:38
 * Version: 0.0.1
 */
public class Test02 {

    public static void main(String[] args) {
        /**
         * 原因，在多态中，编译期，默认是按照类A的异常扑住的，但是实际上可能抛出B的异常
         * 这是要是异常为A的异常的父类，此时将扑捉不到这个异常，将造成运行期异常，线程结束
         */
        try {
            A a = new B();
            a.method1();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class A{
    public void method1() throws IOException {
        System.out.println("fu");
    }
}

class B extends A{

    @Override
    public void method1() throws IOException{
        System.out.println("B");
    }
}