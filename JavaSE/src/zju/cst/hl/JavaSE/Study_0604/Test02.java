package zju.cst.hl.JavaSE.Study_0604;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 练习Runnable接口
 */
public class Test02 {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hhhh");
        }).start();


        List<String> list = Arrays.asList("hello","world");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });

        System.out.println("------");
        list.forEach((s)->{
            System.out.println(s.toUpperCase());
        });
        System.out.println("------");
        List<String> list1 = new ArrayList<>();
        list.forEach((s)->{
            list1.add(s.toUpperCase());
        });

        System.out.println("------");
        //使用流,函数式接口使用lambda表达式实现实例化
        list.stream().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        //函数式接口使用方法引用实现实例化
        list.stream().map(String::toUpperCase).forEach(s-> System.out.println(s));
    }
}
