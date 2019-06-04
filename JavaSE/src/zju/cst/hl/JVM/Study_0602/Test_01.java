package zju.cst.hl.JVM.Study_0602;



/**
 * 双亲委派机制,bootstrap == null
 */
public class Test_01 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
