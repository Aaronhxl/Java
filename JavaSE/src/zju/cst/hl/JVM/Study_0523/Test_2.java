package zju.cst.hl.JVM.Study_0523;

/**
 *  第一种情况：创建了MyParent4的实例，故主动使用，会被初始化
 *  第二种情况：并不在七种主动使用情况之中，故MyParent4不会被初始化
 *  注意到：我们并没有定义[Lzju.cst.hl.JVM.Study_0523.MyParent4，这是由JVM运行期生成的
 */
public class Test_2 {
    public static void main(String[] args) {

        //第一种情况
       // new MyParent4();
        //第二种情况
        MyParent4[] myParent4s = new MyParent4[1];
        //class [Lzju.cst.hl.JVM.Study_0523.MyParent4;
        myParent4s[0] = new MyParent4();
        System.out.println(myParent4s.getClass());
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1);

        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        int[] ints = new int[1];
        ints[0] = 1;
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}