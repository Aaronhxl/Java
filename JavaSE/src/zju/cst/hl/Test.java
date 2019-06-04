package zju.cst.hl;

import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        testGUID();
    }



    public static void testGUID(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(uuid);
        System.out.println(s);
    }
}
