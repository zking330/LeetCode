package A集合.数组.NO11盛水最多的容器;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(nums));
    }

    /**
     * 暴力循环
     * @param height int[]
     * @return int
     */
    public static int maxArea(int[] height) {
        int result = 0,min = 0,length = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                length = j - i;

                if(height[i] > height[j]) {
                    min = height[j];
                }
                else {
                    min = height[i];
                }

                if(result < min * length) {
                    result =  min * length;
                }
            }
        }

        return result;
    }

    /**
     * 双指针解法
     * @param height int[]
     * @return int
     */
    public static int maxArea2(int[] height) {
        int result = 0,temp = 0, left = 0, right = height.length - 1;

        while(right > left) {
            temp = height[left] > height[right]
                    ? height[right] * Math.abs(left - right)
                    : height[left] * Math.abs(left - right);
            result = result > temp ? result : temp;

            if(height[left] >= height[right]) {
                right--;
            }
            else{
                left++;
            }
        }

        return result;
    }
}
