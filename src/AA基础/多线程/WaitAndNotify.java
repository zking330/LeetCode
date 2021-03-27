package AA基础.多线程;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaitAndNotify {
    private static TaskQueue q = new TaskQueue();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> ts = new ArrayList<Thread>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        }
                        catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };

            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);

        for (Thread t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> qu = new LinkedList();

    public synchronized void addTask(String str) {
        this.qu.offer(str);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while(this.qu.isEmpty()) {
            wait();
            System.out.println("=========");
        }

        return this.qu.poll();
    }
}
