package 多线程.thread_basic;

import 多线程.SleepHelper;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T09_Interrupt_and_sync {

    public static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
               SleepHelper.sleepSeconds(10);
            }
        });

        t1.start();

        SleepHelper.sleepSeconds(1);

        Thread t2 = new Thread(() -> {
            synchronized (o) {
            }

            System.out.println("t2 end!");
        });

        t2.start();

        SleepHelper.sleepSeconds(1);

        //线程在 sleep wait join 时会导致抛出 InterruptedException 异常
        //争抢锁的操作不会被interrupt打断
        t2.interrupt();
    }
}
