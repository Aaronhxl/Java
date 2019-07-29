package zju.cst.leetcode.Number_454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Number_454 {

    public static void main(String[] args) {

    }

    /**
     * 不能排序，暴力解决,O(n4)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solution1(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length ; j++) {
                for (int k = 0; k < C.length ; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if(A[i] + B[j] + C[k] + D[l] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    /**
     * 注意到只是返回多少种，故可以排序,对其中2个数组进行排序,O(n3)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solution2(int[] A, int[] B, int[] C, int[] D){
        int count = 0;
        Arrays.sort(C);
        Arrays.sort(D);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length ; j++) {
                int target = - (A[i] + B[j]);
                int k = 0;
                int l = D.length - 1;
                while (k < C.length && l>=0){
                    int nowValue = C[k] + D[l];
                    if(nowValue == target){
                        int numC = 1;
                        int numD = 1;
                        while (k+1 < C.length){
                            if(C[k] == C[k+1]){
                                k++;
                                numC++;
                            }else{
                                k++;
                                break;
                            }
                        }
                        while (l-1>=0){
                            if(D[l] == D[l-1]){
                                l--;
                                numD++;
                            }else {
                                l--;
                                break;
                            }
                        }
                        count += numC*numD;
                    }
                    else if(target > nowValue){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }

        return count;
    }

    /**
     * 使用map存下C,D的各种组合，使用A，B的各种组合对比 O(n2)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solution3(int[] A, int[] B, int[] C, int[] D){

        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < C.length ; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                if(map.containsKey(key)){
                    Integer value = map.get(key);
                    value++;
                    map.put(key, value);
                }else {
                    map.put(key,1 );
                }
            }
        }

        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < B.length; j++) {
                int target = - (A[i] + B[j]);
                if(map.containsKey(target)){
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}
