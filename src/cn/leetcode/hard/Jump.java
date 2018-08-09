package cn.leetcode.hard;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.print(new Jump().jump(nums));
    }

    //贪心
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int jump = 0;  //目前跳了多少步
        int cur = 0;   //只跳jump步，能够到达的最远位置
        int next = 0;  //再多跳一步，能够跳到的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return jump;
    }

    //超出时间限制  dp
    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
