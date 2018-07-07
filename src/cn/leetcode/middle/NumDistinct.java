package cn.leetcode.middle;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 示例 1:
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 */
public class NumDistinct {

    public static void main(String[] args) {
        System.out.print(new NumDistinct().numDistinct3("rabbbit","rabbit"));
    }
    /**
     * DFS方法，效率不高
     * 如果如果S中发现了与T中相同的字符，则去掉S中的此字符，并搜索余下的T
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0 ? 1 : 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                cnt += numDistinct(s.substring(i+1), t.substring(1));
            }
        }

        return cnt;
    }

    /**
     * 动态规划
     * 对于T的前j个字符，S的前i - 1个字符和前i个字符含有子序列都是一样的，也就是dp[i][j] = dp[i - 1][j]。这个是为什么呢？
     * 比如dp[i - 1][j]为2，此时将S的第i个字符加入比较，不会影响结果(这里不考虑第i个字符与第j个字符相等),最后，如果加入的
     * 第i个字符与T的第j个字符相等的话，此时dp[i][j]结果分为两部分，一部分是dp[i - 1][j],这个表示i - 1和j的匹配数量，
     * 一部分是dp[i - 1][j - 1],这个可以理解，既然加入的第i个字符与T的第j个字符相等，可以将S的第i个字符和T的第j个字符去掉，
     * 所以是dp[i - 1][j - 1]。
     * dp[0][0] = 1; // T和S都是空串.
     * dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。
     * dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。
     * dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0).1 <= i <= T.length(), 1 <= j <= S.length()
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[slen][tlen];
    }

    /**
     * 一般来说，如果题目里面给出两个字符串，基本是两种思路，一种就是递归判断，一种就是动态规划，
     * 这里我们可以用f(i,j)表示S中前i个字符串中，T的前j个字符出现的次数，不管S[i]和T[j]相不相等，
     * 首先f(i,j)=f(i-1,j)，其次要是S[i]==T[j]的话，f(i,j) = f(i-1,j)+f(i-1,j-1),
     * 可以看到，i的状态只与i-1有关，于是可以用滚动数组来进行优化。代码类似01背包。
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct3(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j > 0; j--)
                dp[j] += (t.charAt(j - 1) == s.charAt(i - 1) ? dp[j - 1] : 0);
        }
        return dp[t.length()];
    }
}
