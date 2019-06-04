package zju.cst.leetcode.Number_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Number_15 {

    public static void main(String[] args) {

    }

    /**
     * 排序--nlog(n)
     * 固定2个数--n2
     * 二分查找第三个数--log(n)
     * 总时间复杂度n2log(n)+nlog(n)
     * 去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<String> container = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int k = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if(k>=0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    String s = nums[i]+"--"+nums[j]+"--"+nums[k];
                    if(!container.contains(s)){
                        container.add(s);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 参考文章：https://www.cnblogs.com/patatoforsyj/p/9496345.html
     * 思路：
     *      排序-->nlog(n)
     *      以某个数为动态的target-->n
     *      开始找到另外两个数，每次需要走完-->n
     *      总时间复杂度：n2 + nlog(n)
     * @param nums
     * @param version
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums,int version){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]>0)continue;
            if(i>0&&nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int left = i+1,right = len - 1;
            while (left<right){
                if(nums[left] + nums[right] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left<right && nums[left]==nums[left+1]) left++;
                    while (left<right && nums[right]== nums[right-1]) right--;
                    left++;
                    right--;
                }else if(nums[left] + nums[right] > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }

}


