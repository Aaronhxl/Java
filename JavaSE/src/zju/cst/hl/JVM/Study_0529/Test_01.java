package zju.cst.hl.JVM.Study_0529;

/**
 *  验证类的初始化会不会导致其实现的接口初始化
 *  结论：并不会
 */
public class Test_01 {
    public static void main(String[] args) {
        System.out.println(MyChild.b);
    }
}

interface MyParent{
    Thread THREAD = new Thread(){
        {
            System.out.println("Myparent5 invoked");
        }
    };
}
class MyChild implements MyParent{
    public static int b = 5;
}