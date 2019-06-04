package zju.cst.leetcode.Number_11;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Number_11 {
    public static void main(String[] args) {

    }

    /**
     * 暴力法：O(n2)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length ; i++) {
            for (int j = i+1; j < height.length ; j++) {
                int temp = (j-i)*Math.min(height[i],height[j]);
                if(maxArea < temp)
                    maxArea = temp;
            }
        }
        return maxArea;
    }

    /**
     * 双指针法
     * @param height
     * @param version
     * @return
     */
    public int maxArea(int[] height,int version){

        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;

    }
}
