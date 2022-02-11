package 多线程.ordering;

/**
 * @author kai.zheng
 * @className T02_NoVisibility
 * @date 2022/2/11 14:59
 */
public class T02_NoVisibility {
    private /* volatile */ static boolean ready = false;
    private static int number;

    private static class ReaderThreads extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThreads();
        t.start();
        number = 42;
        ready = true;
        t.join();
    }
}
