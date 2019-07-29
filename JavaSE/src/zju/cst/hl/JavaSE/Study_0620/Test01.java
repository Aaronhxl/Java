package zju.cst.hl.JavaSE.Study_0620;

/**
 * Package: zju.cst.hl.JavaSE.Study_0620
 * Description： char占用2个字节
 * Author: huanglong
 * Date: Created in 2019/6/20 23:25
 * Version: 0.0.1
 */
public class Test01 {
    public static void main(String[] args) {
        /**
         *  /u代表Unicode编码，但是底层依旧是2个字节，可以转成int类型，精度不会丢失
         */
        System.out.println((int) Character.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE);
    }
}
