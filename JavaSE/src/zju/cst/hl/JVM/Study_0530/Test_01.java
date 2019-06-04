package zju.cst.hl.JVM.Study_0530;

/**
 * 类加载器
 *      Bootstrap类加载器
 *      Extension类加载器
 *      Application类加载器
 *      用户自定义类加载器
 *
 *      返回null为Bootstrap类加载器加载的
 */
public class Test_01 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());//Bootstrap类加载器加载String

        Class c = Class.forName("zju.cst.hl.JVM.Study_0530.C");//sun.misc.Launcher$AppClassLoader@18b4aac2,一般由此类加载器加载用户自定义类
        System.out.println(c.getClassLoader());

    }
}

class C{

}
