package 多线程.thread_basic;

import 多线程.SleepHelper;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T07_Interrupt_and_sleep {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is Interrupted.");
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        //线程在 sleep wait join 时会导致抛出 InterruptedException 异常
        t.interrupt();
    }
}
