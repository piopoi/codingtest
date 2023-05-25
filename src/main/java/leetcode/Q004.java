package leetcode;

/**
 * LeetCode - Prolems
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class Q004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newNums = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i <= nums1.length || j <= nums2.length) {
            if(nums1[i] < nums2[j]) {
                newNums[k++] = nums1[i++];
            } else {
                newNums[k++] = nums2[j++];
            }
        }

        if(newNums.length % 2 == 0) {
            return newNums[newNums.length / 2 - 1];
        } else {
            return (double) (newNums[newNums.length / 2 - 1] + newNums[newNums.length / 2]) / 2;
        }
    }
}
