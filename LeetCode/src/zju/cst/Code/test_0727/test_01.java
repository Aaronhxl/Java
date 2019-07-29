package zju.cst.Code.test_0727;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Package: zju.cst.Code.test_0727
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/27 20:24
 * Version: 0.0.1
 */
public class test_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            sc.nextLine();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < num; i++) {
                String s = sc.nextLine();
                boolean flag = false;
                if(!set.isEmpty()){
                    for (String source : set) {
                        if(s.length() == source.length()){
                            if (!fun(source,s)){
                                flag = true;
                            }
                        }
                    }
                    if(!flag){
                        set.add(s);
                    }
                }else {
                    set.add(s);
                }
            }
            System.out.println(set.size());
        }
    }

    //相等返回false
    private static boolean fun(String sourece,String s){
        int lenth = s.length();
        for (int i = 0; i <lenth ; i++) {
            String temp = s.substring(i,lenth)+s.substring(0,i);
            if(temp.equals(sourece)){
                return false;
            }
        }
        return true;
    }
}
