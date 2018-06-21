package cn.leetcode.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {

    public static void main(String[] args) {


    }
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return 0;
    }
    //二分查找
    public int searchInsert2(int[] nums, int target) {

        return 0;
    }
}
