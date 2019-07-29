package zju.cst.Code.test_0727;

import java.util.Scanner;
import java.util.Set;

/**
 * Package: zju.cst.Code.test_0727
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/7/27 21:34
 * Version: 0.0.1
 */
public class test_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            sc.nextLine();
            int[] data = new int[num];
            for (int i = 0; i < num; i++) {
                data[i] = sc.nextInt();
            }
            //以每个数为核心，向左或向右移动，求最大
            int res = 0;
            for (int i = 0; i < num ; i++) {
                int max = fun(data, i);
                if(res < max ){
                    res =  max;
                }
            }
            System.out.println(res);
        }
    }

    private static int fun(int[] array,int index){
        int max = 0;
        int data = array[index];
        int i = index - 1;
        int j = index + 1;
        if(index == 0 || array[j] < data){
            // 右移动
            int lenth1 = 0;
            int lenth2 = 0;
            boolean flag = true;
            for (int k = index; k < array.length ; k++) {
                if(flag){
                    if(data > array[k]){
                        lenth1++;
                    }else {
                        flag = false;
                    }
                    if(k+1 < array.length && array[k+1] > array[k]){
                        lenth2++;
                    }
                    else {
                        flag = false;
                    }
                }else {
                    break;
                }
            }
            return lenth1<lenth2?lenth1+1:lenth2+1;

        }else if (index == array.length - 1 || array[i] > data){
            //左移动
            int lenth1 = 0;
            int lenth2 = 0;
            boolean flag = true;
            for (int k = index; k >= 0 ; k--) {
                if(flag){
                    if(data < array[k]){
                        lenth1++;
                    }else {
                        flag = false;
                    }
                    if(k>=1 && array[k] > array[k-1]){
                        lenth2++;
                    }
                    else {
                        flag = false;
                    }
                }else {
                    break;
                }
            }
            return lenth1<lenth2?lenth1+1:lenth2+1;
        }
        return max;
    }

    private static int right(int[] array,int index){
        int max = 0;
        return max;
    }
}
