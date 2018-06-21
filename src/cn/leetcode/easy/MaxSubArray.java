package cn.leetcode.easy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums == null || nums.length == 0) {
            return max;
        }
        int curSum = nums[0];
        max = curSum;
        for(int i  = 1; i < nums.length;i++) {
            if(curSum < 0) {
                curSum = nums[i];
            }else{
                curSum += nums[i];
            }
            if(max < curSum) {
                max = curSum;
            }
        }

        return max;
    }
}
