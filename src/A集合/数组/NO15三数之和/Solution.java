package A集合.数组.NO15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai.zheng
 * @description Solution
 * @date 2021/3/29 16:58
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }


    public static Object threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length <= 2) {
            return ans;
        }

        // O(nlogn)
        Arrays.sort(nums);

        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;

                    //跳过重复的值
                    while(left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }

                    //跳过重复的值
                    while(left < right && nums[right] == nums[right + 1]) {
                        right --;
                    }
                }
                else if(nums[left] + nums[right] < target) {
                    left ++;
                }
                else {
                    right --;
                }
            }
        }

        return ans;
    }
}
