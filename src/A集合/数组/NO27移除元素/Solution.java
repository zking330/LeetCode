package A集合.数组.NO27移除元素;

import java.util.Arrays;

/**
 * @author kai.zheng
 * @className Solution
 * @date 2021/4/15 16:14
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        System.out.println(removeElement(nums, 3) + "");
    }

    /**
     * 校验去掉数值为val后，长度的数组
     * 逻辑删除数值为val的数
     * 即将不等val的数前移
     * @param nums int[]
     * @param val int
     * @return int
     */
    public static int removeElement(int[] nums, int val) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[ans] = nums[i];
                ans ++;
            }
        }

        return ans;
    }

}
