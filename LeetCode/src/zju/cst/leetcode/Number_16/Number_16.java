package zju.cst.leetcode.Number_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Number_16 {

    public static void main(String[] args) {

        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums, -1));
    }

    /**
     * 思路：
     *      1.排序->nlogn
     *      2.前后指针->指向首尾
     *      3.以某个数开始向其集中
     *
     *      时间复杂度：n2
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i < len-1 ; i++) {
            int left = 0 ,right = len - 1;
            while (left<i&&right>i){
                int temp = nums[left] + nums[right] + nums[i];
                if(Math.abs(temp-target)<diff){
                    diff = Math.abs(temp-target);
                    res = temp;
                }
                if(Math.abs(temp-target)== 0) {
                    res = temp;
                    break;
                }
                else if(temp < target) left++;
                else right--;
            }
        }
        return res;
    }

    /**
     * 此算法优于上述算法
     * @param nums
     * @param target
     * @param version
     * @return
     */
    public static int threeSumClosest(int[] nums, int target,int version){

        Arrays.sort(nums);

        int diff= Integer.MAX_VALUE;
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len - 2 ; i++) {
            int left = i+1,right = len-1;
            while (left<right){
                int temp = nums[left] + nums[right] + nums[i];
                if(Math.abs(temp - target)<diff){
                    diff = Math.abs(temp-target);
                    res = temp;
                }
                if(Math.abs(temp-target)== 0) {
                    res = temp;
                    break;
                }
                else if(temp < target) left++;
                else right--;
            }
        }
        return res;
    }
}


