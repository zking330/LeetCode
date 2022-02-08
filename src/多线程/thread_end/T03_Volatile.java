package 多线程.thread_end;

import 多线程.SleepHelper;

public class T03_Volatile {

    public static volatile boolean running = true;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            long i = 0L;

            while (running) {
                i++;
            }

            System.out.println("end and i = " + i);
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        running = false;

    }
}
