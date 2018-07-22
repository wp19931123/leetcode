package cn.leetcode.extend;

/**
 * 0-1背包问题（动态规划）
 */
public class Knapsack {

    public static void main(String[] args) {
        int weight[] = {2, 3, 4, 5};
        int value[] = {3, 4, 5, 7};
        int maxweight = 9;
        System.out.println(knapsack(weight, value, maxweight));
    }

    public static int knapsack(int[] weight, int[] value, int maxweight) {

        int n = weight.length;
        //最大价值数组为maxvalue[N+1][maxWeight+1]，因为我们要从0开始保存
        int[][] maxvalue = new int[n + 1][maxweight + 1];

        //重量和物品为0时，价值为0
        for (int i = 0; i < maxweight + 1; i++) {
            maxvalue[0][i] = 0;

        }
        for (int i = 0; i < n + 1; i++) {
            maxvalue[i][0] = 0;

        }

        //i：只拿前i件物品（这里的i因为取了0，所以对应到weight和value里面都是i-1号位置）
        //j：假设能取的总重量为j
        //n是物品件数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxweight; j++) {
                //当前最大价值等于放上一件的最大价值
                maxvalue[i][j] = maxvalue[i - 1][j];
                //如果当前件的重量小于总重量，可以放进去或者拿出别的东西再放进去
                if (weight[i - 1] <= j) {
                    //比较（不放这个物品的价值）和
                    //（这个物品的价值 加上 当前能放的总重量减去当前物品重量时取前i-1个物品时的对应重量时候的最高价值）
                    if (maxvalue[i - 1][j - weight[i - 1]] + value[i - 1] > maxvalue[i - 1][j]) {
                        maxvalue[i][j] = maxvalue[i - 1][j - weight[i - 1]] + value[i - 1];
                    }
                }
            }
        }
        return maxvalue[n][maxweight];
    }

    public static int knapsack2(int[] weight, int[] value, int maxweight) {
        //用2*C的空间复杂度解决问题
        int n = weight.length;
        int[][] dp = new int[2][maxweight + 1]; //交替来更新新的一行
        //初始化第一行
        for (int i = 0; i <= maxweight; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxweight; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= weight[i]) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], value[i] + dp[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return dp[(n - 1) % 2][maxweight];
    }

    public static int knapsack01(int[] weight, int[] value, int maxweight) {
        int n = weight.length;

        int[] dp = new int[n + 1];   //只用O(n）的空间复杂度解决
        for (int i = 0; i <= maxweight; i++) {  //初始化第一行
            dp[i] = i > weight[0] ? value[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = maxweight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[maxweight];
    }

}
