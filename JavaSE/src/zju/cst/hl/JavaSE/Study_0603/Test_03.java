package zju.cst.hl.JavaSE.Study_0603;

@FunctionalInterface
interface MyInterface{
    void test();
    String toString();
}

public class Test_03 {

    public static void myTest(MyInterface myInterface){
        System.out.println("before invoke");
        myInterface.test();
        System.out.println("after invoke");
    }

    public static void main(String[] args) {

        myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("this is a test demo");
            }
        });
        System.out.println("-------");
        //认为是该类的一种具体的实现
        myTest(()->{
            System.out.println("this is lambda demo");
        });

        System.out.println("--------");

        MyInterface myInterface = ()->{
            System.out.println("myInterface implement");
        };
        System.out.println(myInterface);
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
    }
}
