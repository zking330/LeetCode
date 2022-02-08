package 多线程.thread_basic;

import 多线程.SleepHelper;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T06_Interrupt_and_interrupted {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (;;) {
                //interrupt之后 判断为true 并将标志位重置
                if(Thread.interrupted()) {
                    System.out.println("Thread is Interrupted!");
                    //重置后 此处输出为false
                    System.out.println(Thread.interrupted());
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(2);

        t.interrupt();

        //interrupted是查询当前线程的标志位（主线程）
        System.out.println("main: " + t.interrupted());
    }
}
