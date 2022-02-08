package 多线程.thread_end;

import 多线程.SleepHelper;

public class T02_Suspend_Resume {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (true) {
               System.out.println("go on");
               SleepHelper.sleepSeconds(1);
           }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        t.suspend();
        SleepHelper.sleepSeconds(3);
        t.resume();

    }
}
