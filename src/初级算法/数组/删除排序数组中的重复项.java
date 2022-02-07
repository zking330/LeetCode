package 初级算法.数组;

/**
 * @author kai.zheng
 * @className 删除排序数组中的重复项
 * @date 2021/10/29 14:45
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {

        int num = check(new int[] {0,0,1,1,1,2,2,3,3,4});
        System.out.println();
    }

    private static int check(int[] ints) {
        if(ints.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < ints.length; j++) {
            if(ints[i] != ints[j]) {
                i++;
                ints[i] = ints[j];
            }
        }

        return i + 1;
    }
}
