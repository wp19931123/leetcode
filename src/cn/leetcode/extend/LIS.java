package cn.leetcode.extend;

public class LIS {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 7};
        int maxLength = new LIS().lis(array);
        System.out.println("maxLength=" + maxLength);
    }

    /**
     * dp[i]=max(dp[i],dp[j]+1)其中j<i,并且array[i]>array[j]
     * dp[i]表示以array[i]为末元素的最长递增子序列的长度
     *
     * @param array
     * @return
     */
    public int lis(int[] array) {
        int length = array.length;
        if (length == 0)
            return 0;
        int maxCount = 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
                if (maxCount < dp[i]) {
                    maxCount = dp[i];
                }

            }
        }
        return maxCount;
    }
}
