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

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }

    /**
     * 1.去掉空格
     * 2.拿到符号
     * 3.分割数字
     * 4。运算  逆波兰表达式求解
     * @param s
     * @return
     */
    public static int calculate(String s) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c !=' '){
                temp.append(c);
            }
        }
        String mid = temp.toString();
        int pre = 0,later = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<String> opretion = new Stack<>();
        int flag = 0;
        for (int i = 0; i < mid.length() ; i++) {
            char c = mid.charAt(i);
            if (c < '0' || c > '9' || i == mid.length() - 1){//此时为操作符
                if(i!=mid.length()-1){
                    later = i;
                }else {
                    later = mid.length();
                }
                String number = mid.substring(pre, later);
                pre = i + 1;
                int data = Integer.parseInt(number);
                nums.add(data);

                if(flag == 1){
                    if(nums.size()>=2){
                        Integer num1 = nums.pop();
                        Integer num2 = nums.pop();
                        String opre = opretion.pop();
                        if (opre.equals("*")){
                            nums.add(num1*num2);
                        }else {
                            nums.add(num2/num1);
                        }
                        flag = 0;
                    }
                }

                switch (c){
                    case '-':
                        opretion.add("-");
                        break;
                    case '+':
                        opretion.add("+");
                        break;
                    case '*':
                        opretion.add("*");
                        flag = 1;
                        break;
                    case '/':
                        opretion.add("/");
                        flag = 1;
                        break;
                        default:
                }
                if (flag!=1 && opretion.size()==2){
                    String pop1 = opretion.pop();
                    String pop2 = opretion.pop();
                    Integer num1 = nums.pop();
                    Integer num2 = nums.pop();
                    if(pop2.equals("-")){
                        nums.add(num2-num1);
                    }else {
                        nums.add(num2+num1);
                    }
                    opretion.add(pop1);
                }
            }
        }
        while (!opretion.isEmpty()){
            String pop2 = opretion.pop();
            Integer num1 = nums.pop();
            Integer num2 = nums.pop();
            if(pop2.equals("-")){
                nums.add(num2-num1);
            }else {
                nums.add(num2+num1);
            }
        }
        return nums.pop();
    }

}

