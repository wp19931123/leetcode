package cn.leetcode.middle;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 说明: 你可以假设所有输入都会得到有效的结果。
 * 进阶: 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class WiggleSort {

    public static void main(String[] args) {
        int[] nums = {1};
        new WiggleSort().wiggleSort(nums);
    }

    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int mid = (nums.length + 1) / 2;
        int l = mid, r = nums.length;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = i % 2 == 0 ? nums[--l] : nums[--r];
        }
        for(int i = 0;i < tmp.length;i++) {
            nums[i] = tmp[i];
            System.out.print(nums[i]);
        }
    }
}
