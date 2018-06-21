package cn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 */
public class TwoNumSum {
    //暴力法，时间复杂度为O(N)
    public int[] twoSumA(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length;i++) {
            for(int j = i+1;j < nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    //一次哈希法，时间空间复杂度都是O(N)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
