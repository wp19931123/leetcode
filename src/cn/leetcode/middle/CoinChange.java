package cn.leetcode.middle;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。你可以认为每种硬币的数量是无限的。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 */
public class CoinChange {

    /**
     * 动态规划，用dp存储硬币数量，dp[i] 表示凑齐钱数 i 需要的最少硬币数，那么凑齐钱数 amount 最少硬币数为：
     * 固定钱数为 coins[j] 一枚硬币，另外的钱数为 amount - coins[j] 它的数量为dp[amount - coins[j]]，
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == 0x7fffffff ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x7fff_fffe;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

}
