package A集合.数组.NO26删除有序数组的重复项;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,2,3,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

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
