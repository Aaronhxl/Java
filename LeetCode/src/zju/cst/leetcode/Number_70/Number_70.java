package zju.cst.leetcode.Number_70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Number_70 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 非递归
     * @param n
     * @param version
     * @return
     */
    public int climbStairs(int n,int version){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int pre_1 = 1,pre_2 = 2;
        int result = 0;
        for (int i = 3; i <= n ; i++) {
            result = pre_1 + pre_2;
            pre_1 = pre_2;
            pre_2 = result;
        }
        return result;
    }
}
