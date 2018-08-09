package cn.leetcode.middle;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 示例:
 * 输入: n = 10  输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:1 是丑数。n 不超过1690。
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        for (int i = 1; i < n; i++) {
            int min = min(2 * arr[m2], 3 * arr[m3], 5 * arr[m5]);
            arr[i] = min;
            while (2 * arr[m2] <= arr[i]) {
                m2++;
            }
            while (3 * arr[m3] <= arr[i]) {
                m3++;
            }
            while (5 * arr[m5] <= arr[i]) {
                m5++;
            }
        }

        return arr[n - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
