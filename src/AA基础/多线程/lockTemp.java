package AA基础.多线程;

public class lockTemp {

    public void run() {
        synchronized(Main.lockA) {
            System.out.println("run lockA");
            sleep1s();

            synchronized (Main.lockB){
                sleep1s();
                System.out.println("run lockB");
            }
        }
    }

    public void dec() {
        synchronized(Main.lockB) {
            System.out.println("dec lockA");
            sleep1s();

            synchronized (Main.lockA){
                System.out.println("dec lockB");
                sleep1s();
            }
        }
    }

    static void sleep1s() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
