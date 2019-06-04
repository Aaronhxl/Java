package zju.cst.hl.JVM.Study_0527;

/**
 * 分析下例中counter2在不同顺序的输出
 */
public class Test_2 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton{
    public static int counter1;
    //public static int counter2 = 0;
    private static Singleton singleton = new Singleton();
    private Singleton(){
        counter1++;
        counter2++;
    }
    public static int counter2 = 0;
    public static Singleton getSingleton(){
        return singleton;
    }

}