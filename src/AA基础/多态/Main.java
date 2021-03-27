package AA基础.多态;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
//        show(new Cat());  // 以 Cat 对象调用 show 方法
//        show(new Dog());  // 以 Dog 对象调用 show 方法
//
//        Animal a = new Cat();  // 向上转型
//        a.eat();               // 调用的是 Cat 的 eat
//        Cat c = (Cat) a;        // 向下转型
//        c.work();        // 调用的是 Cat 的 work

        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<String, Integer>();
        lmap.put("2", 3);
        lmap.put("1", 2);
        lmap.put("3", 1);

        for (String key : lmap.keySet()) {
            System.out.println(key + ":" + lmap.get(key));
        }

        Set<Map.Entry<String, Integer>> set = lmap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        CopyOnWriteArrayList cpList = new CopyOnWriteArrayList();

        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            int value = (int) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        Cat cat = new Cat();
        cat.eat();
        cat.work();
    }

    public static void show(Animal a)  {
        a.eat();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }
}

class test {
    public void eat() {
        System.out.println("吃骨头");
    }
    public void work() {
        System.out.println("看家");
    }
}
