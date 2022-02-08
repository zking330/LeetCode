package 多线程;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T05_Interrupt_and_isInterrupted {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (;;) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is Interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                }else {
                    System.out.println("Thread Not Interrupted!");
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(2);

        t.interrupt();
    }
}
