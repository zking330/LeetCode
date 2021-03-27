package AA基础.多线程.重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main extends Thread {
    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();

            try {
                if(lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(aa);
                    }
                    finally {
                        lock.unlock();
                    }
                }

                condition.await();
                condition.signalAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static int aa = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
}
