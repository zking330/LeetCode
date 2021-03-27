package AA基础.多线程;

public class Threads extends Thread{

    public static void main (String[] args) throws InterruptedException {
        temp2();
    }

    /**
     * 守护线程
     */
    static void temp2() {
        Thread th1 = new Thread(() -> {
            System.out.println("===start====");

            try {
                Thread.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        th1.start();

        Thread th2 = new Thread(() -> {
            while(true) {
                System.out.println("111111111");
            }
        });

        th2.setDaemon(true);
        th2.start();
    }

    /**
     * 设置标志位中断线程
     */
    static void temp1() throws InterruptedException{
        MyThread1 t = new MyThread1();
        t.start();
        Thread.sleep(1);
        t.running = false;
    }

    static class MyThread1 extends Thread {
        public volatile boolean running = true;

        public void run() {
            while(running) {
                System.out.println("aaaaa");
            }

            System.out.println("====end====");
        }
    }

    /**
     * 线程处于等待状态时，调用interrupt()会抛出InterruptedException异常
     * 此时应该中止线程
     */
    static void temp0() throws InterruptedException{
        System.out.println("main start...");
        Thread temp = new MyThread();
        temp.start();
        Thread.sleep(10);
        temp.interrupt();
        System.out.println("=====End=====");
    }

    static class MyThread extends Thread {
        public void run() {
            int n = 0;

            while(! isInterrupted()) {
                n++;
                System.out.println(n + "Hallow");

                try {
                    Thread.sleep(100);
                    throw new InterruptedException();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
