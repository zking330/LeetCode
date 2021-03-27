package AA基础.多线程;

/**
 * 线程安全的对象
 */
public class Count {
    private int count = 0;

//    public void add(int n) {
//        synchronized(this) {
//            while(true) {
//                System.out.println(n);
//            }
//        }
//    }

    //以下写法等价
//    public synchronized void add(int n) { // 锁住this
//        count += n;
//    } // 解锁

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}
