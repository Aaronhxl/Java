package zju.cst.hl.JavaSE.Study_0605;

public class Test04 {
    public static void main(String[] args) {
        System.out.println(new Test04().method());
        System.out.println(new Test04().method2());

    }

    public int method(){
        int x = 1;
        try {
            return x;
        }finally {
            ++x;
        }
    }

    public int method2(){
        int x = 1;
        try{
            return x;
        }finally {
            return ++x;
        }
    }
}
