package 多线程.thread_end;

import 多线程.SleepHelper;

public class T01_Stop {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (true) {
               System.out.println("go on");
               SleepHelper.sleepSeconds(1);
           }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        t.stop();

    }
}
