package zju.cst.hl.JavaSE.Study_0604;

/**
 * lambda表示的是一个对象
 */
public class Test01 {
    public static void main(String[] args) {

        myInterface1 myInterface1 = ()->{};
        System.out.println(myInterface1.getClass().getInterfaces()[0]);//看其实现的接口
        myInterface2 myInterface2 = ()->{};
        System.out.println(myInterface2.getClass().getInterfaces()[0]);

        //()->{};lambda表达式一定是能根据上下文断定的，这样没有上下文就是一个错误的写法
    }
}


@FunctionalInterface
interface myInterface1{
    void method();
}

@FunctionalInterface
interface myInterface2{
    void method();
}