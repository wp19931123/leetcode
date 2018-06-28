package cn.leetcode.middle;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        new NextPermutation().nextPermutation(arr);
        for(int i : arr) {
            System.out.print(i+" ");
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        for(int i = nums.length-1;i >= 1;i--) {
            if(nums[i] > nums[i-1]) {
                //从后面找到一个比nums[i-1]大的最小的数，然后后面自然排序
                int j = findLargeMin(nums,i-1);
                swap(nums,i-1,j);
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        Arrays.sort(nums);
        return;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
    private int findLargeMin(int[] arr,int i) {
        for(int j = arr.length-1;j > i;j--) {
            if(arr[j] > arr[i]) {
                return j;
            }
        }
        return i+1;
    }
}
