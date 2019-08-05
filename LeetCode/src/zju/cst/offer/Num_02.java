package zju.cst.offer;

/**
 *汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *来源：https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Num_02 {

    public static void main(String[] args) {
        //System.out.println(leftRotateString("abcXYZdef", 3));

        int a = -782511781;

        System.out.println(Integer.toBinaryString(a));
        //long b = (long) (a & 0xFFFFFFFF);
        //System.out.println(b);
        String s = Integer.toBinaryString(a);
        long b = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '1'){
                b += (long) Math.pow(2, 31-i);
            }
        }

        System.out.println(b);

    }

    public static String leftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            return null;
        }
        int length = str.length();
        int index = n%length;
        return str.substring(index) + str.substring(0, index);

    }
}
