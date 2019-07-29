package zju.cst.hl.JavaSE.Study_0620;

import sun.text.normalizer.UBiDiProps;

/**
 * Package: zju.cst.hl.JavaSE.Study_0620
 * Description： 函数override时候，函数的返回值大小应该大于等于父类的权限修饰符
 * Author: huanglong
 * Date: Created in 2019/6/20 23:56
 * Version: 0.0.1
 */
public class Test04 {
    /**
     * 还是多态中的问题，默认以父类为标准，要是子类访问不了，那么就会有问题
     */
}

class E{
    public void fun(){
        System.out.println("E");
    }
}

class F extends E{
    @Override
    public void fun(){
        System.out.println("F");
    }
}