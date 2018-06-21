package cn.leetcode.easy;

public class MaxProfit2 {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.print(new MaxProfit2().maxProfit(arr));
    }

    //分析可知，要想利益最大化，就应该每次在波谷买进，波峰卖出，这样利益最大
    //波峰减波谷等于波峰到波谷的元素依次相减的和，写出公式就知道是抵消的。
    //a,b,c,d,e    e-a = e-d+d-c+c-b+b-a
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for(int i = 1; i < prices.length;i++) {
            int d = prices[i] - prices[i-1];
            if(d > 0) {
                max += d;
            }
        }
        return max;
    }

}
