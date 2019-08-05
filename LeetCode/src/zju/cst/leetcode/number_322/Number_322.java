package zju.cst.leetcode.number_322;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_322 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int res = coinChange3(coins, amount);
        System.out.println(res);

    }

    /**
     * 动态规划：
     *      状态转移方程：f(n) = min{f(n-i)} + 1;
     *      暴力递归
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount==0) {
            return 0;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //金额不可达
           if(amount<coins[i]) continue;
           int subAnswer = coinChange(coins, amount - coins[i]);
           //子问题无解
           if(subAnswer == -1) continue;
           answer = Math.min(answer, subAnswer+1);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    /**
     * 带备忘录的递归
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount){
        int[] temp = new int[amount];
        return fun(temp, coins, amount);
    }
    private static int fun(int[] temp,int[] coins,int amount){
        if(amount == 0){
            return 0;
        }
        if(temp[amount] != 0){
            return temp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if(amount<coins[i]) continue;
            int sub = fun(temp, coins, amount-coins[i]);
            if(sub == -1) continue;
            ans = Math.min(ans, sub+1);
        }
        //记录本轮答案
        temp[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
        return temp[amount];
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length ; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] >amount? -1:dp[amount];
    }

}