package zju.cst.hl.JavaSE.Study_0609;

import java.util.Arrays;

/**
 * String类的分析理解
 *          String实现了comparable接口，重写了compareTo方法，可以用于自己写类进行判断排序，也可以使用collections，
 *          Arrays工具类的sort进行排序。只有集合或数组中的元素实现了comparable接口，并重写了compareTo才能使用工具类排序。
 *          String类中唯一的一条本地方法，既不是用Java语言实现的方法。
 *          比如str.intern(),作用就是去字符串常量池中寻找str字符串，如果有则返回str在常量池中的引用，如果没有则在常量池中创建str对象
 *
 *          String对象是真的无法修改吗？
 *          答案是否定的，还是有途径修改的，那就是通过反射。
 *          因为final的是字符数组，只代表这个value变量的引用不能改变，不代表value指向的对象不可以改变，
 *          String只是没有提供修改的途径，即使有也会是不对外公开。但数组中的元素是可以修改的，虽然没有途径，
 *          但还是反射就是一个逆天的存在，我们可以通过反射的途径去修改字符数组value的元素的值。
 *          所以String的不可变性仅仅是正常情况下的不可变，但绝非完全的不可变。
 *
 */
public class Test02 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String(str1);
        System.out.println(str1 == str2);

        String[] str = {"js","jm","vn"};
        Arrays.sort(str);

        String intern = "abc".intern();
        String intern2 = str2.intern();

        System.out.println(intern == str1);
        System.out.println(intern2 == str1);

        String s1 = new String("huanglong");
        String s2 = new String("huanglong");
        System.out.println(s1 == s2);

        String s3 = s1.intern();
        String s4 = s2.intern();
        String s5 = "huanglong";

        System.out.println(s3 == s4);
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);

    }
}
