package cn.leetcode.easy;

/**
 * 用三种以上方法
 * 空间复杂度O（1）
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int i = k % nums.length;
        reverseArray(nums,0,nums.length-i-1);
        reverseArray(nums,nums.length-i,nums.length-1);
        reverseArray(nums,0,nums.length-1);
    }

    public static void reverseArray(int[] arr,int l,int r) {
        while(l < r) {
            swap(arr,l++,r--);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
