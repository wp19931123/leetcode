package cn.leetcode.easy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.print(new MaxProfit().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices == null || prices.length == 0) {
            return max;
        }
        for(int i = 0;i < prices.length;i++) {
            for(int j = i+1;j < prices.length;j++) {
                int d = prices[j] - prices[i];
                if(d > max) {
                    max = d;
                }
            }
        }
        return max;
    }

}
