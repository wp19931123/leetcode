package exam.CMBCard;

//BestTimeToBuyStock_Easy
public class CMBCard2 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int i = 0, j = 1;
        while (j < prices.length) {
            if (prices[j] <= prices[i]) {
                i = j;
                j++;
                continue;
            }
            int temp = prices[j] - prices[i];
            maxProfit = (temp > maxProfit) ? temp : maxProfit;
            j++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
