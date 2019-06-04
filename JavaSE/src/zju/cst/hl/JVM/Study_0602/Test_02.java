package zju.cst.hl.JVM.Study_0602;

public class Test_02 {

    public static void main(String[] args) {
        //通常是启动资源的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        String resourceName = "";
    }
}
