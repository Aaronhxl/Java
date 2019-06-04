package zju.cst.hl.JavaSE.Study_0603;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda表达式
 */
public class Test_01 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //遍历的方式
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
        //jdk1.5 增强for
        System.out.println("-------");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("-------");
        //jdk1.8  foreach
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("-----");
        list.forEach(i->{ //类型推断
            System.out.println(i);
        });

        System.out.println("------");

        //method reference,语法不一样，通过这样方式创建一个函数式接口的实例，这也是jdk1.8的新特性
        list.forEach(System.out::println);
    }
}
