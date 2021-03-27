package AA基础.排序.冒泡;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] aa = {1, 9, 4, 8, 5, 2, 3, 6};

//        int[] aa = {1, 2, 3, 4};
        int[] bb = sort(aa);

        System.out.println(Arrays.toString(bb));
    }

    private static int[] sort(int[] aa) {
        int[] result = Arrays.copyOf(aa, aa.length);
        boolean isChange = false;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if(result[j] > result[j + 1]) {
                    int temp = result[j + 1];
                    result[j + 1] = result[j];
                    result[j] = temp;
                    isChange = true;
                }
            }

            if(!isChange) {
                break;
            }
        }

        return result;
    }
}
