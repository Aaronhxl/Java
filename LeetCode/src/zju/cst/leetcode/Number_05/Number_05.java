package zju.cst.leetcode.Number_05;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Number_05 {
    public static void main(String[] args) {
        System.out.println(Solution02("babad"));
    }

    /**
     * 基于找到所有的可能，对每次组合判断是否是回文
     *      复杂度分析：
     *          1.组合的复杂度为O(n2)
     *          2.对比的复杂度为O(n)
     *          3.综合复杂度为O(n3)
     */
    public static String Solution01(String str){

        //当输入条件为null或者空字符串时，应返回空字符串
        if(str == null || str.length() == 0) return "";
        String res = "";
        int len = str.length();
        for (int i = 0; i < len ; i++) {
            for (int j = i+1; j <= len ; j++) {
                String subString = str.substring(i,j);
                String reverseString = new StringBuilder(subString).reverse().toString();
                if(subString.equals(reverseString) && res.length() < subString.length()){
                    res = subString;
                }
            }
        }
        return res;
    }

    /**
     * 基于扩散的思想：
     *      最长回文字串的扩散，根据回文的长度可分为奇数和偶数
     *      若为奇数，那么其中中间数中的两边必然为相同，偶数，则中间两个数（中间的也必须相同）的两边必然相同
     *      那么，比较奇数和偶数回文串中的最长字串即为所求
     *
     *      复杂度分析：
     *          奇数情况：
     *          1.每个数都可以当作中间数故其复杂度为O(n)
     *          2.开始扩散其平均时间复杂度也为O(n)
     *          3.综合为O(n2)
     *          偶数情况：
     *          复杂度同上
     *          综上所述：该算法的时间复杂度为O(n2)
     * @param str
     * @return
     */
    public static String Solution02(String str){

        if(str == null || str.length() == 0) return "";
        if(str.length() == 1) return str;

        String odd = "";
        String even = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int start = i,end = i;
            while (start>=0 && end<len){
                if(str.charAt(start) == str.charAt(end)){
                    start--;
                    end++;
                }
                else break;
            }
            if(odd.length()<(end - start + 1)){
                odd = str.substring(start+1, end);//注意这里出来的时候start和end已经是自减或自增了
            }
        }

        for (int i = 0; i <len-1 ; i++) {
            if(str.charAt(i)!=str.charAt(i+1)) continue;
            int start = i,end = i+1;
            while (start>=0 && end<len){
                if(str.charAt(start) == str.charAt(end)){
                    start--;
                    end++;
                }
                else break;
            }
            if(even.length()<(end - start + 1)){
                even = str.substring(start+1, end);
            }
        }
        return odd.length()>even.length()?odd:even;
    }
}
