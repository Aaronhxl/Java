package zju.cst.Code.test_0727;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Package: zju.cst.Code.test_0727
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/27 20:56
 * Version: 0.0.1
 */
public class test_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int result = 0;
            int num = sc.nextInt();
            sc.nextLine();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = sc.nextInt();
            }
            int length = array.length;
            for (int i = 0; i < length; i++) {
                for (int j = i+1; j < length; j++) {
                    for (int k = j+1; k < length ; k++) {
                        int a = array[i];
                        int b = array[j];
                        int c = array[k];
                        if(a+b > c && a+c>b && b+c >a){
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
