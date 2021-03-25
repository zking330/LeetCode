package NO456一二三模式;

/**
 * @author kai.zheng
 * @description Solution
 * @date 2021/3/24 14:20
 */
public class Solution {
    public static void main(String[] args) {
        int[] test = new int[] {-1,3,2,0};
        System.out.println(find132pattern(test));
    }

    public static boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int numsi = nums[0];

        for (int j = 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if(numsi < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }

            numsi = Math.min(numsi, nums[j]);
        }

        return false;
    }
}
