package A集合.数组.NO26删除有序数组的重复项;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,2,3,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 双指针的解法
     * @param nums int[]
     * @return int
     * 已经排序好的数组
     * 只遍历一遍
     * 计数后需要替换前面的数字，用于比对后续的值
     * 返回i+1, 因为是从0开始计数
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
