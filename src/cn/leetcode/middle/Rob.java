package cn.leetcode.middle;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {2,1,1,2,5};
        System.out.print(new Rob().rob(nums));
    }

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len <= 3) {
            int count = nums[0];
            for(int i = 1;i < len;i++) {
                count = Math.max(count,nums[i]);
            }
            return count;
        }
        int[] cnt1 = new int[len - 1];  //[0,n-2]
        int[] cnt2 = new int[len - 1];  //[1,n-1]
        cnt1[0] = nums[0];
        cnt1[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        cnt2[0] = nums[1];
        cnt2[1] = nums[1] > nums[2] ? nums[1] : nums[2];
        for (int i = 2; i < len - 1; i++) {
            cnt1[i] = Math.max(cnt1[i-1],cnt1[i-2] + nums[i]);
            cnt2[i] = Math.max(cnt2[i-1],cnt2[i-2] + nums[i + 1]);
        }
        return cnt1[len-2] > cnt2[len-2] ? cnt1[len-2] : cnt2[len-2];
    }

}
