package zju.cst.hl.JavaSE.Study_0605;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hl","zq","myk");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.toString());

        Collections.sort(list, (o1,o2)->{
            return o1.compareTo(o2);
        });

        Collections.sort(list, (o1,o2)->o1.compareTo(o2));
        Collections.sort(list, Comparator.reverseOrder());

        Myinterface myinterface = (a) -> a*a ;
        System.out.println(myinterface.add(1));
    }
}

@FunctionalInterface
interface Myinterface{
    int add(int a);
}