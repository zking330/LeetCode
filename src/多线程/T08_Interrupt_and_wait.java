package 多线程;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T08_Interrupt_and_wait {

    public static Object o = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread is Interrupted.");
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        //线程在 sleep wait join 时会导致抛出 InterruptedException 异常
        t.interrupt();
    }
}
