package cn.leetcode.middle;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 输入: [1,2,3,0,2]    输出: 3
 * 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = {6, 1, 3, 2, 4, 7};
        System.out.println(new MaxProfit().maxProfit(arr));
    }

    /**
     * 动态规划
     * 未持有股票的状态，最大利润有两种可能。一，和昨天一样保持未持有；二，昨天持有股票今天卖掉。
     * sdp[i] = Math.max(sdp[i-1],bdp[i-1] + prices[i]);
     * 持有股票的状态，最大利润也有两种可能。一，和昨天一样持有股票不卖；二，两天前未持有（休息一天）今天购买。
     * bdp[i] = Math.max(bdp[i-1],sdp[i-2] - prices[i])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sdp = new int[prices.length];
        int[] bdp = new int[prices.length];
        sdp[0] = 0;
        bdp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sdp[i] = Math.max(sdp[i - 1], bdp[i - 1] + prices[i]);
            if (i >= 2) {
                bdp[i] = Math.max(bdp[i - 1], sdp[i - 2] - prices[i]);
            } else {
                bdp[i] = Math.max(bdp[i - 1], -prices[i]);
            }
        }
        return sdp[prices.length - 1];
    }

    //改写成空间复杂度为O(1）的
    public int maxProfit2(int[] prices) {
        int bye = Integer.MIN_VALUE, pre_bye = 0, sell = 0, pre_sell = 0;
        for (int p : prices) {
            pre_bye = bye;
            bye = Math.max(pre_sell - p, pre_bye);
            pre_sell = sell;
            sell = Math.max(pre_bye + p, pre_sell);
        }
        return sell;
    }
}
