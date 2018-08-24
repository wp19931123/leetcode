package cn.leetcode.hard;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 均不为空。
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    /**
     * 如果数组a的中位数小于数组b的中位数，那么整体的中位数只可能出现在a的右区间加上b的左区间之中；
     * 如果数组a的中位数大于等于数组b的中位数，那么整体的中位数只可能出现在a的左区间加上b的右区间之中。
     * 关键就是利用分治的思想逐渐缩小a的区间和b的区间来找到中位数。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if ((l1 + l2) % 2 == 1) {
            flag = true;
        }
        return findMedianSortedArrays(nums1, 0, l1, nums2, 0, l2);
    }

    boolean flag = false; //总数是否为奇数

    private double findMedianSortedArrays(int[] nums1, int b1, int e1, int[] nums2, int b2, int e2) {
        int mid1 = b1 + (e1 - b1) / 2;
        int mid2 = b2 + (e2 - b2) / 2;
        if (b1 == 0 || e1 == nums1.length - 1 || b2 == 0 || b2 == nums2.length - 1) {

        }
        int midNum1 = getMidNum(nums1, b1, e1, mid1);
        int midNum2 = getMidNum(nums1, b1, e2, mid2);
        if (midNum1 < midNum2) {
            return findMedianSortedArrays(nums1, mid1, e1, nums2, b2, mid2);
        } else {
            return findMedianSortedArrays(nums1, b1, mid1, nums2, mid2, e2);
        }
    }

    //获取中位数
    private int getMidNum(int[] nums1, int b, int e, int mid) {
        int midNum1;
        if ((e - b + 1) % 2 == 1) {
            midNum1 = nums1[mid];
        } else {
            midNum1 = nums1[mid] + (nums1[mid + 1] - nums1[mid]) / 2;
        }
        return midNum1;
    }
}
