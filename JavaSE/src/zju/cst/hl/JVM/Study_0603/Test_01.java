package zju.cst.hl.JVM.Study_0603;

/**
 * ClassLoader的JavaDoc分析，结合该天的笔记
 */
public class Test_01 {
    public static void main(String[] args) {


        int[] array = new int[10];
        System.out.println(array.getClass().getClassLoader());//基本元素的数组ClassLoader是null

        String[] ao = new String[10];
        System.out.println(ao.getClass().getClassLoader());
        System.out.println(String.class.getClassLoader());


        Test_01[] test_01s = new Test_01[10];
        System.out.println(test_01s.getClass().getClassLoader());//数组类型Class对象的类加载器与其元素的类型的Class对象的类加载器是一样的
        System.out.println(Test_01.class.getClassLoader());
    }

}
