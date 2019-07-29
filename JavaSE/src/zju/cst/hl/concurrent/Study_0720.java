package zju.cst.hl.concurrent;

/**
 * Package: zju.cst.hl.concurrent
 * Description： volatile
 * Author: huanglong
 * Date: Created in 2019/7/20 23:51
 * Version: 0.0.1
 */
public class Study_0720 {

    private volatile boolean flag = false;
    private int a = 1;
    public static void main(String[] args)  {
        Study_0720 s = new Study_0720();

        new Thread(()->{
            s.write();
        }).start();
        new Thread(()->{
            s.read();
        }).start();
    }

    private void write(){
        flag = true;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = 0;
    }

    private void read(){
        if(flag){
            System.out.println(a);
        }
    }
}
