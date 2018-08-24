package cn.leetcode.middle;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }

    /**
     * 采用动态规划思想求解。对于n个结点，除去根节点，还剩余n-1个结点，因此左右子树的结点数分配方式如下所示：
     * (0,n-1), (1,n-2), (2, n-3), ....(n-1,0)
     * 我们可以简单的得到：
     * n=0时，种类数为dp(n)=1；n=1时，种类数为dp(n)=1；
     * 也可以直接构造卡特兰数公式求解
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
