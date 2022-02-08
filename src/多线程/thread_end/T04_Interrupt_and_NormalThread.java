package 多线程.thread_end;

import 多线程.SleepHelper;

public class T04_Interrupt_and_NormalThread {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            long i = 0L;

            while (!Thread.interrupted()) {
                i++;
            }

            System.out.println("end and i = " + i);
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        t.interrupt();
    }
}
