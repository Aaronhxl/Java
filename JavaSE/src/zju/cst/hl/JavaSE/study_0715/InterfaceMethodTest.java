package zju.cst.hl.JavaSE.study_0715;

/**
 * Package: zju.cst.hl.JavaSE.study_0715
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/15 15:23
 * Version: 0.0.1
 */
public class InterfaceMethodTest {
    public static void main(String[] args) {
        InterfaceMethod.method1();
        new C().sayHello();
        /**
         * Java8中，接口的实现类对象不能访问静态方法，但是能访问静态成员变量
         */
        new InterfaceMethod(){}.method2();
        System.out.println(new InterfaceMethod() {
        }.key);

      //  new StaticClass().method();
    }
}
