package zju.cst.hl.JavaSE.study_0712;

/**
 * Package: zju.cst.hl.JavaSE.study_0712
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/12 17:21
 * Version: 0.0.1
 */
public class Test01 {

    public static void main(String[] args) {
        Fu fu = new Fu() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        int i = fu.hashCode();
        System.out.println(i);

       // Fu fu1 = new Fu();
    }


}

