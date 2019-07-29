package zju.cst.Code.test_0727;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Package: zju.cst.Code.test_0727
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/27 21:06
 * Version: 0.0.1
 */
public class test_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            sc.nextLine();
            int[] a = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = sc.nextInt();
                for (int j = 0; j <= i/2 ; j++) {
                    int temp = a[j];
                    a[j] = a[i-j];
                    a[i-j] = temp;
                }
            }

            for (int i = 0; i < num ; i++) {
                if(i != 0){
                    System.out.print(" ");
                }
                System.out.print(a[i]);
            }
        }
    }
}
