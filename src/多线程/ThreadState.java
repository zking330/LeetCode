package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        //======================
        Thread t1 = new Thread(() -> {
            System.out.println("2: " + Thread.currentThread().getState());

            for (int i = 0; i < 3; i++) {
                SleepHelper.sleepSeconds(1);
                System.out.print(i + " ");
            }

            System.out.println();
        });

        System.out.println("1: " + t1.getState());
        t1.start();
        t1.join();
        System.out.println("3: " + t1.getState());
        //======================
        Thread t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 go on!");
            SleepHelper.sleepSeconds(5);
        });

        t2.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("4: " + t2.getState());

        LockSupport.unpark(t2);
        SleepHelper.sleepSeconds(1);
        System.out.println("5: " + t2.getState());
        //======================
        //synchronized才能进入block状态
        final Object o = new Object();

        Thread t3 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t3 得到了锁 o");
            }
        });

        new Thread(() -> {
            synchronized (o) {
                SleepHelper.sleepSeconds(5);
            }
        }).start();

        SleepHelper.sleepSeconds(1);

        t3.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("6: " + t3.getState());
        //======================
        //waiting状态
        final Lock lock = new ReentrantLock();

        Thread t4 = new Thread(() -> {
            lock.lock();
            System.out.println("t4 得到了锁 lock");
            lock.unlock();
        });

        new Thread(() -> {
            lock.lock();
            SleepHelper.sleepSeconds(5);
            lock.unlock();
        }).start();

        SleepHelper.sleepSeconds(1);

        t4.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("7：" + t4.getState());
        //======================
        Thread t5 = new Thread(() -> {
           LockSupport.park();
        });

        t5.start();

        SleepHelper.sleepSeconds(1);

        System.out.println("8：" + t5.getState());
        LockSupport.unpark(t5);
        //======================
    }
}
