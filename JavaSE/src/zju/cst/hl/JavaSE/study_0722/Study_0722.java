package zju.cst.hl.JavaSE.study_0722;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Package: zju.cst.hl.JavaSE.study_0722
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/22 23:58
 * Version: 0.0.1
 */
public class Study_0722 {

    public static void main(String[] args) {

       new ArrayList(){
            {
                this.add("111");
                add("222");
            }
        };

       new HashMap(){
           {
               put("as", "sd");
           }
       };

    }
}
