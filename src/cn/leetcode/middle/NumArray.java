package cn.leetcode.middle;

import javax.swing.text.Segment;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * 说明:
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
public class NumArray {

    public static void main(String[] args) {
        int[] arr = {};
        NumArray na = new NumArray(arr);
    }

    int[] arr;
    int sum = 0;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = nums[i];
        }
    }

    public void update(int i, int val) {
        if (i < 0 || i >= arr.length) {
            throw new RuntimeException("err");
        }
        arr[i] = val;
    }

    public int sumRange(int i, int j) {
        if (i > j || i < 0 || j >= arr.length) {
            return 0;
        }
        sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }
}
