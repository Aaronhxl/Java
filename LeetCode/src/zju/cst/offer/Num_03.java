package zju.cst.offer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 来源：https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Num_03 {


    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }

    public static String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        String[] s = str.split(" ");
        //注意这里需要考虑输入全为空格的情况
        if(s.length == 0){
            return str;
        }
        StringBuilder result = new StringBuilder();
        for (int i = s.length - 1; i >= 0 ; i--) {
            if(i != s.length - 1){
                result.append(" ");
            }
            result.append(s[i]);
        }
        return result.toString();
    }
}
