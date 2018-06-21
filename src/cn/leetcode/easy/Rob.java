package cn.leetcode.easy;

public class Rob {

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.print(new Rob().robDP(nums));
    }
    //DP思想，按奇偶分别来更新a和b，这样就可以保证组成最大和的数字不相邻
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i = 0;i < nums.length;i++) {
            if(i % 2 == 0) {
                a = Math.max(a+nums[i],b);
            }else{
                b = Math.max(b+nums[i],a);
            }
        }
        return Math.max(a,b);
    }
    //递推公式dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
    //dp[0]=nums[0],dp[1]=max{nums[0],nums[1]}
    public int robDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length;i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
