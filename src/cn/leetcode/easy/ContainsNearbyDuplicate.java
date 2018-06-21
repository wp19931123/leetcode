package cn.leetcode.easy;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length;i++) {
            for(int j = i+1;j < nums.length && j <= i+k;j++) {
                if(nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
