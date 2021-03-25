package A数组.NO4寻找两个正序数组的中位数;

/**
 * @author kai.zheng
 * @description Solution
 * @date 2021/3/25 15:59
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,5,7};
        int[] nums2 = new int[] {2,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        if(m == 0) {
            if(n % 2 == 0) {
                return(nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }
            else {
                return nums2[n / 2];
            }
        }
        if(n == 0) {
            if(m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            }
            else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;

        while(count != (m + n)) {
            if(i == m) {
                while(j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if(j == n) {
                while(i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }
            else {
                nums[count++] = nums2[j++];
            }
        }

        if(count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        }
        else {
            return nums[count / 2];
        }
    }
}
