package zju.cst.leetcode.number_227;

import java.util.List;
import java.util.Stack;

/**
 *实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_227 {

    /**
     * 1.去掉空格
     * 2.拿到符号
     * 3.分割数字
     * 4。运算
     * @param s
     * @return
     */
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] >= '0') {
                num = num * 10 + sarr[i] - '0';
            }
            if ((sarr[i] < '0' && sarr[i] != ' ') || i == sarr.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*' || sign == '/') {
                    int top = stack.pop();
                    stack.push(sign == '*' ? top * num : top / num);
                }
                sign = sarr[i];
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}

