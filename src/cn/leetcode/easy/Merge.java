package cn.leetcode.easy;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Merge().merge(nums1,3,nums2,3);
        for(int i : nums1) {
            System.out.print(i+" ");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m+n-1;
        int end1 = m-1;
        int end2 = n-1;
        while(end >= 0 && end1 >= 0 && end2 >= 0) {
            if(nums1[end1] > nums2[end2]) {
                nums1[end--] = nums1[end1--];
            }else if(nums1[end1] < nums2[end2]){
                nums1[end--] = nums2[end2--];
            }else{
                nums1[end--] = nums1[end1--];
                nums1[end--] = nums2[end2--];
            }
        }
        while(end2 >= 0) {
            nums1[end--] = nums2[end2--];
        }
    }
}
