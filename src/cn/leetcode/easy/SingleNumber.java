package cn.leetcode.easy;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums == null) {
            throw new RuntimeException("input error");
        }
        int res = 0;
        for(int i = 0;i < nums.length;i++) {
            res ^= nums[i];
        }
        return res;
    }

}
