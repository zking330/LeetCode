package AA基础.多线程;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int num = 0;
    static int another = 1;
    static final Object lockA = new Object();
    static final Object lockB = new Object();

    public static void main(String[] args) throws Exception {
        lockTemp lo = new lockTemp();
        lockTemp lo2 = new lockTemp();

        Queue<String> queue = new LinkedList<>();

        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

//        new Thread(() -> {
//            lo.run();
//        }).start();
//
//        new Thread(() -> {
//            lo2.dec();
//        }).start();

        System.out.println("=========");

    }
}
