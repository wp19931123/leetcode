package cn.leetcode.middle;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度
 */
public class CanJump {

    public static void main(String[] args) {
        int[] arr = {1,1,1,0};
        System.out.println(new CanJump().canJump(arr));
    }

    /**
     * 动态规划：假设位置i(0≤i≤A.length)能够跳跃的最大长度为dp[i]，其状态转换方程为：
     * dp[i]={max{A[i]+i,dp[i−1]},  if dp[i−1]≥i
     *        0                    otherwise
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums == null) {
            return false;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            if(dp[i-1] >= len-1) {
                return true;
            }
            if(dp[i-1] >= i) {
                dp[i] = Math.max(nums[i] + i,dp[i-1]);
            }else{
                return false;
            }
        }
        return true;
    }

    //贪心算法
    public boolean canJump2(int[] nums) {
        if(nums == null) {
            return false;
        }
        int len = nums.length;
        int curMaxStep = nums[0];
        for(int i = 1;i < len;i++) {
            if(curMaxStep >= len-1) {
                return true;
            }
            if(curMaxStep >= i) {
                curMaxStep = Math.max(nums[i]+i,curMaxStep);
            }else{
                return false;
            }
        }
        return true;
    }

}
