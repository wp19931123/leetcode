package cn.leetcode.easy;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 输入的数组只包含 0 和1。
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == 1) {
                count++;
                if(max < count) {
                    max = count;
                }
            }else{
                count = 0;
            }
        }
        return max;
    }
}
