package zju.cst.hl.JavaSE.study_0715;

import java.math.BigDecimal;

/**
 * Package: zju.cst.hl.JavaSE.study_0715
 * Description： 大浮点数得取整函数
 * Author: huanglong
 * Date: Created in 2019/7/15 22:58
 * Version: 0.0.1
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bg = new BigDecimal(2362.76);
        System.out.println(bg.setScale(0, BigDecimal.ROUND_DOWN).intValue());
    }
}
