package 多线程.false_sharing;

import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;

/**
 * @author kai.zheng
 * @className T05_Contenden
 * @date 2022/2/10 15:21
 */
public class T05_Contenden {
    public static long COUNT = 10_0000_0000L;

    private static class T {
//        @Contended
        //806647000
        //1115044900
        public long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println(System.nanoTime() - start);
    }
}
