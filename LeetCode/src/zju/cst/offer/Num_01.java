package zju.cst.offer;

import java.util.ArrayList;

/**
 *输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 来源：https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Num_01 {

    /**
     * 数组已经排序好了，那么可以从两头分别出发验证
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0) {
            return result;
        }
        int left = 0,right = array.length - 1;
        int mult = Integer.MAX_VALUE;
        int min = array[left],max = array[right] ;
        boolean flag = false;
        while (left < right){
            if(array[left] + array[right] == sum){
                if(mult>array[left]*array[right]){
                    mult = array[left]*array[right];
                    min = array[left];
                    max = array[right];
                    flag = true;
                }
                left++;
                right--;
            }else if(array[left] + array[right] < sum){
                left++;
            }else {
                right--;
            }
        }
        if(flag){
            result.add(min);
            result.add(max);
        }
        return result;
    }
}
