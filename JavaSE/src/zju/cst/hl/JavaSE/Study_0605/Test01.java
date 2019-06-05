package zju.cst.hl.JavaSE.Study_0605;

import java.util.function.Function;

/**
 *  函数式接口Function的介绍
 */
public class Test01 {
    public static void main(String[] args) {

        /**
         * 这是一种方法引用，以下这种格式，类名::实例方法，则调用该方法的必然是Function<T,R>中的T，也就是入参对象
         * 也就是对应的lambda表达式的参数
         */
        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}
