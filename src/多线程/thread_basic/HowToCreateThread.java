package 多线程.thread_basic;

import java.util.concurrent.*;

public class HowToCreateThread {

    //继承Thread类之后，无法继承其它类
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hallo MyThread!");
        }
    }

    //实现Runnable更合适，可以继承其它类
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hallo MyRun!");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() {
            System.out.println("Hallo MyRun!");
            return "MyCall Success.";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、继承Threads类
        new MyThread().start();

        //2、实现Runnable接口
        new Thread(new MyRun()).start();

        //3、lambda表达式
        new Thread(() -> {
            System.out.println("Hallo Lambda!");
        }).start();

        //4、线程池
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            System.out.println("Hallo ThreadPool!");
        });

        //5.1、带返回值的线程(通过线程池)
        Future<String> f = service.submit(new MyCall());
        String s = f.get();
        System.out.println(s);

        //5.2、带返回值的线程(不通过线程池)
        //FutureTask已经实现Runnable接口
        FutureTask<String> task = new FutureTask<>(new MyCall());
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());

        //关闭线程池
        service.shutdown();
    }

}
