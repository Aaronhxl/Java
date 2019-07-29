package zju.cst.hl.JavaSE.Study_0620;

/**
 * Package: zju.cst.hl.JavaSE.Study_0620
 * Description： 函数override的时候，返回值类型将是父类的子类或相等
 * Author: huanglong
 * Date: Created in 2019/6/20 23:48
 * Version: 0.0.1
 */
public class Test03 {

    public static void main(String[] args) {

        /**
         * 原因也很简单，多态中调用的时候，默认为A类的实例，如果B类的实例，返回的数据类型大于A类的
         * 那么A类的，将接收不了，将会造成类型不匹配异常
         */

    }
}

class C{
    public Object fun(){
        System.out.println("C");
        return null;
    }
}

class D extends C{
    @Override
    public Object fun(){
        System.out.println("D");
        return null;
    }
}