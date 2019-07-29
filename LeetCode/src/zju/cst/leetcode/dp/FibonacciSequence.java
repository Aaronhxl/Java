package zju.cst.leetcode.dp;

/**
 * 斐波那契数列理解动态规划思想：
 *      暴力递归问题
 *      带备忘录的递归问题
 *      非递归的动态规划算法
 *      以上三类问题是可以转化的
 *      参考文章：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
 */
public class FibonacciSequence {

    /**
     * 递归暴力解决，画出递归树，分析可知，算法复杂度呈现指数级的上升2^n
     * @param n
     * @return
     */
    private int solution1(int n){
        if(n == 1 || n == 2) {
            return 1;
        }
        else {
            return solution1(n - 1) + solution1(n - 2);
        }
    }

    /**
     * 带备忘录的递归算法，剪枝完实际上的时间复杂度为O(n)
     * 但是，占用额外系统递归栈，占用内存
     */
    private static int[] temp = null;
    private int solution2(int n){
        if(temp == null) {
            temp = new int[n+1];
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if (temp[n] != 0){  //剪枝，指数级下降
            return temp[n];
        }
        temp[n] = solution2(n - 1) + solution2(n - 2);
        return temp[n];
    }


    /**
     * 动态规划问题
     * @param n
     * @return
     */
    private int solution3(int n){
        int a = 1 ,b = 1;
        if(n == 1 || n == 2 ) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
          a = a + b;
          a = b;
          b = a;
        }
         return b;
    }


    public static void main(String[] args) {

        for (int j = -128; j < 128 ; j++) {

            int result = 0;
            byte tByte = (byte) j;
            String tString = Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1);
           // System.out.println(tString);
            for (int i = 0; i <tString.length() ; i++) {
                if(tString.charAt(i) == '1'){
                    result += (int) Math.pow(2, 7-i);
                }
            }
            short  n = (short) (tByte & 0xFF);
            System.out.println(n);
            if (result != n){
                System.out.println(false);
            }

        }

    }

}
