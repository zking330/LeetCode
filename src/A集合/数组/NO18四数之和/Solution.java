package A集合.数组.NO18四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai.zheng
 * @description Solution
 * @date 2021/4/7 14:39
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum0(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        if(nums == null && nums.length < 4) {
            return answer;
        }

        Arrays.sort(nums);

        int left = 0; int right = nums.length - 1;

        while(right - left > 2) {
            int left0 = left + 1;
            int right0 = right - 1;
            int sum = nums[left] + nums[left0] + nums[right] + nums[right0];

            while (left0 < right0) {
                if(nums[left] + nums[left0] + nums[right] + nums[right0] - target == 0) {
                    answer.add(Arrays.asList(nums[left], nums[left0], nums[right0], nums[right]));
                    left0++;right0--;

                    while(right0 > left0 && nums[left0] == nums[left0 - 1]) {
                        left0 ++;
                    }

                    while(right0 > left0 && nums[right0] == nums[right0 + 1]) {
                        right0 --;
                    }
                }
                else if(nums[left] + nums[left0] + nums[right] + nums[right0] - target > 0) {
                    right0--;
                }
                else if(nums[left] + nums[left0] + nums[right] + nums[right0] - target < 0) {
                    left0++;
                }
            }

            if(right - left > 2) {
                //todo 初始就等于0会丢失部分数据
                if(sum - target == 0) {
                    right--;left++;
                    left0 = left + 1;
                    right0 = right - 1;
                }
                else if(sum - target > 0) {
                    right--;
                    right0 = right - 1;
                }
                else if(sum - target < 0) {
                    left++;
                    left0 = left + 1;
                }
                else {
                    break;
                }

                while(left > 0 && right - left > 2 && nums[left] == nums[left - 1]) {
                    left ++;
                }

                while(right < nums.length - 1 && right - left > 2 && nums[right] == nums[right + 1]) {
                    right --;
                }
            }
        }

        return answer;
    }

    public static List<List<Integer>> fourSum0(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
