package zju.cst.hl.JavaSE.Study_0603;

@FunctionalInterface
public interface Test_02 {

    void test();//只有一个抽象方法
    /**
     * 这个方法是重写Object类中的方法，所以其实换个角度说，
     * 在它的实现类中一定包含这个方法，所以实际上它的抽象方法还是一个
     * @return
     */
    /**
     * 从函数式接口的注释中我们可以了解到
     * If
     * an interface declares an abstract method overriding one of the
     * public methods of {@code java.lang.Object}, that also does
     * <em>not</em> count toward the interface's abstract method count
     * since any implementation of the interface will have an
     * implementation from {@code java.lang.Object} or elsewhere.
     * @return
     */
    String toString();
}
