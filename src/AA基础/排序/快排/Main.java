package AA基础.排序.快排;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] aa = {1, 7, 8, 3, 5, 2};
        quickSort(aa);
        System.out.println(Arrays.toString(aa));
    }

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        int len;

        if(array == null
                || (len = array.length) == 0
                || len == 1) {
            return ;
        }

        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;

        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
         sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
