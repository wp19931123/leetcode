package cn.leetcode.middle;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 输入: "226"
 * 输出: 3
 */
public class NumDecodings {

    //跟斐波那契数组的递推式一样
    //dp[i]表示到s字符串的第i位可以解码的方法数
    public int numDecodings(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        //限制条件，一位数时不能为0，两位数不能大于26，其十位上的数也不能为0
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            //i-2位要么是1，要么是2并且i-1位不超过6
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];

    }
}
