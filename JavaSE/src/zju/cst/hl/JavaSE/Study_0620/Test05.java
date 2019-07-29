package zju.cst.hl.JavaSE.Study_0620;

/**
 * Package: zju.cst.hl.JavaSE.Study_0620
 * Description： finally语句
 * Author: huanglong
 * Date: Created in 2019/6/21 0:37
 * Version: 0.0.1
 */
public class Test05 {

    /**
     * 有四种情况finally语句不会执行
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println(1);
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //int i = 1/0;
            System.out.println(2);
        }
    }
}
