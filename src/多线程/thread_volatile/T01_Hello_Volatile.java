package 多线程.thread_volatile;

import 多线程.SleepHelper;

public class T01_Hello_Volatile {
    //volatile保持线程可见性
    public static volatile boolean running = true;

    private static void m() {
        System.out.println("m start!");

        while (running) {
            //solt 中含有synchronized保证了可见性
//            System.out.println("======");
        }

        System.out.println("m end!");

    }

    public static void main(String[] args) {
        new Thread(T01_Hello_Volatile::m, "t1").start();

        SleepHelper.sleepSeconds(1);

        running = false;
    }

}
