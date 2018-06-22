package cn.leetcode.middle;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(new ThreeSumClosest().threeSumClosest(arr,1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            throw new RuntimeException("Invalid Error");
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i < nums.length;i++) {
            for(int j = i+1;j < nums.length;j++) {
                for(int k = j+1;k < nums.length;k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int cur = sum > target ? sum - target : target - sum;
                    if(cur < min) {
                        min = cur;
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}
