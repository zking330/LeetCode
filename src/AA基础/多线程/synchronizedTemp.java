package AA基础.多线程;

import java.util.Date;

/**
 * 线程同步
 */
public class synchronizedTemp {
    public static void main(String[] args) throws Exception {
        start0();
    }

    /**
     * 线程安全示例
     */
    static void start0() throws Exception {
        Count c1 = new Count();
        Count c2 = new Count();

        Thread aa = new Thread(() -> {
            c1.add(10);
        });

        Thread bb = new Thread(() -> {
            c1.dec(10);
        });

        aa.start();
        bb.start();
        aa.join();
        bb.join();
        System.out.println(c1.get());
//        System.out.println(c2.get());
    }

    /**
     *
     */
    static void start() throws Exception {
        long startDate = new Date().getTime();
        Thread[] ts = new Thread[] { new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread() };

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
        long endDate = new Date().getTime();
        System.out.println((endDate - startDate));
    }
}

class Counter {
    public static final Object teacherLock = new Object();
    public static final Object studentLock = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(Counter.studentLock) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(Counter.studentLock) {
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(Counter.teacherLock) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(Counter.teacherLock) {
                Counter.teacherCount -= 1;
            }
        }
    }
}
