package AA基础.集合;

import java.util.LinkedList;
import java.util.Queue;

public class queueTemp {

    public static void main(String[] args) throws Exception {
        Queue<String> qu = new LinkedList<String>();

        qu.offer("aaa");
        qu.offer("bbb");
        qu.offer("ccc");
        qu.offer("ddd");
        int size = qu.size();

        for (int i = 0; i < size; i++) {
            System.out.println(qu.poll());
        }

        System.out.println(qu.size());
    }

}
