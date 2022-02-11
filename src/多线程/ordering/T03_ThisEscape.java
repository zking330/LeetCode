package 多线程.ordering;

import java.io.IOException;

/**
 * @author kai.zheng
 * @className T02_NoVisibility
 * @date 2022/2/11 14:59
 */
public class T03_ThisEscape {

    private int num = 8;

    public T03_ThisEscape() {
        new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new T03_ThisEscape();
        System.in.read();
    }

}
