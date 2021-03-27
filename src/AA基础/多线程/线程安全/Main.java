package AA基础.多线程.线程安全;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static AA基础.多线程.线程安全.Counter.ticKetLock;

public class Main {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            es.submit(new saleTicket(i));
        }

        es.shutdown();
    }
}

class Counter {
    static final Object ticKetLock = new Object();
}

class saleTicket extends Thread {
    private final int name;
    static int ticket = 20;

    public saleTicket(int i) {
        this.name = i;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ticKetLock) {
                if (ticket > 0) {
                    ticket--;
                    System.out.println(this.name + "-已售出门票，还有" + ticket + "张");
                }
                else{
                    System.out.println(this.name + "-售票结束！===");
                    return;
                }
            }

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class test {

    public void Haha() {

    }

    public int Haha(int a) {
        return a;
    }
}