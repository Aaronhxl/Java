package zju.cst.hl.JavaSE.Study_0605;

import java.util.function.Function;

public class Test03 {
    public static void main(String[] args) {
        Test03 t = new Test03();
        System.out.println(t.function(10, val -> val * val));
    }

    public int function(int a, Function<Integer,Integer> f){
        return f.apply(a);
    }
}
