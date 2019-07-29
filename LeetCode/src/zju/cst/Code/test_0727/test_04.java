package zju.cst.Code.test_0727;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Package: zju.cst.Code.test_0727
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/27 21:21
 * Version: 0.0.1
 */
public class test_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if(s1.length() == 0 || s2.length() == 0){
                System.out.println(0);
            }
            Set<String> set = new HashSet<>();
            int result = 0;
            for (int i = 0; i < s1.length() ; i++) {
                for (int j = i+1; j <= s1.length(); j++) {
                    String temp = s1.substring(i, j);
                    set.add(temp);
                }
            }
            for (int i = 0; i < s2.length() ; i++) {
                for (int j = i+1; j <= s2.length() ; j++) {
                    String temp = s2.substring(i, j);
                    if(set.contains(temp)){
                        if(result < temp.length()){
                            result = temp.length();
                        }
                    }
                }
            }

            System.out.println(result);
        }

    }
}
