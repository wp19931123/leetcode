package cn.leetcode.middle;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 示例 1:
 * 输入: [5,7]
 * 输出: 4
 */
public class RangeBitwiseAnd {

    public static void main(String[] args) {
        System.out.print(new RangeBitwiseAnd().rangeBitwiseAnd2(5, 7));
    }


    public int rangeBitwiseAnd2(int m, int n) {
        if (m == n) {
            return m;
        }
        int i;
        for (i = 31; i > 0; i--) {
            if ((m & (1 << i)) != (n & (1 << i))) {
                break;
            }
        }
        return m & (~((1 << i + 1) - 1));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int[] bit = new int[32];

        int bitMask = 1;
        for (int j = 31; j >= 0; j--) {
            int val = m & bitMask;
            bit[j] = val;
            bitMask <<= 1;
        }

        for (int i = 1; i <= n - m; i++) {
            bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int val = (i + m) & bitMask;
                bit[j] &= val;
                bitMask <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bit[i];
        }
        return res;
    }
}
