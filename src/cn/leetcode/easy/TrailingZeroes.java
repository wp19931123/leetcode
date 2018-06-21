package cn.leetcode.easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 你算法的时间复杂度应为 O(log n) 。
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        System.out.print(new TrailingZeroes().trailingZeroes(10));
    }
    //求解思路：
    //n的阶乘 = a * 10 ^ k = a * 5 ^ k * 2 ^ k
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
