package AA基础.集合;

import java.util.*;

public class SetConversion {

    public static void main(String[] args) {
        String[] arry = {"1", "2", "3"};

        List list = arrayToList(arry);
        listToArry(list);

        Set set = listToSet(list);
        setToList(set);
    }

    /**
     * Set转List
     */
    private static List setToList(Set set) {
        List list = new ArrayList(set);
        return list;
    }

    /**
     * List转Set
     */
    private static Set listToSet(List list) {
        Set resultSet = new HashSet(list);
        return resultSet;
    }

    /**
     * List转数组
     */
    private static void listToArry(List list) {
        Object[] resultArry = list.toArray();
        System.out.println(Arrays.toString(resultArry));
    }

    /**
     * 数组转List
     */
    public static List arrayToList (String[] arry) {
        List resultList = new ArrayList(Arrays.asList(arry));
        resultList.add("4");
        System.out.println(resultList.size());
        return resultList;
    }
}
