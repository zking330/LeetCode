package 多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kai.zheng
 * @className T05_Interrupt_and_isInterrupted
 * @date 2022/2/8 14:42
 */
public class T11_Interrupt_and_lockInterruptibly {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            
            try {
                SleepHelper.sleepSeconds(10);
            } finally {
                lock.unlock();
            }

            System.out.println("t1 end!");
        });

        t1.start();

        SleepHelper.sleepSeconds(1);

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start!");

            try {
                //可以被打断的过程
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
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
