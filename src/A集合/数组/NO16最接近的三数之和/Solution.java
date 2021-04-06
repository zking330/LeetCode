package A集合.数组.NO16最接近的三数之和;

import java.util.Arrays;

/**
 * @author kai.zheng
 * @description Solution
 * @date 2021/4/6 15:45
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,0};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null) {
            return 0;
        }

        switch (nums.length) {
            case 2:
                return nums[0] + nums[1];
            case 1:
                return nums[0];
        }

        Arrays.sort(nums);
        Integer sum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                int temp = nums[i] + nums[left] + nums[right];

                if(Math.abs(temp - target) < Math.abs(sum - target)) {
                    sum = temp;
                }

                if(temp < target) {
                    left ++;
                }
                else if(temp > target) {
                    right --;
                }
                else {
                    return sum;
                }
            }
        }

        return sum;
    }
}
