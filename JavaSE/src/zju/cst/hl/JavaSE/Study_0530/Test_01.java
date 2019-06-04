package zju.cst.hl.JavaSE.Study_0530;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的理解：
 *      1.泛型只是允许在编译时检测到非法的类型而已，在运行期，泛型标志会变化为Object类型
 *      2.<? extends T> 表示上界，即传入的参数应该为其或其子类
 *      3.<? super T> 表示下界，即传入的参数应该为其或其父类
 */
public class Test_01 {

    public static void main(String[] args) {
        List<Integer> i = new ArrayList<>();
        List<String> s = new ArrayList<>();

        System.out.println(i.getClass());
        System.out.println(s.getClass());

        System.out.println(i.getClass().equals(s.getClass()));//true
    }
}
