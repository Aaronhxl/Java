package zju.cst.hl.JavaSE.Study_0609;

/**
 * Math类中的取整函数
 */
public class Test01 {
    public static void main(String[] args) {
        //round函数在四舍五入的情况下，总是向大的方向偏，-10.5 -》-10 ，10.5 -》11，返回的数据类注意float ->int double -> long
        System.out.println(Math.round(10.4));
        System.out.println(Math.round(10.5));
        System.out.println(Math.round(-10.6));
        System.out.println(Math.round(-10.5));
        System.out.println(Math.round(-10.4));
        System.out.println(Math.ceil(10.5));
        System.out.println(Math.ceil(-10.6));
        System.out.println(Math.floor(10.5));
        System.out.println(Math.floor(-10.4));
    }
}
