package cn.leetcode.easy;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 */
public class MySqrt {
    //牛顿逼近法
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x) {
            r = (r + x/r) / 2;
        }
        return (int)r;
    }

    public int mySqrt2(int x) {
        long i = 1;//int会溢出
        while (i * i < x) {
        i *= 2;
        }
        while (i * i > x) {
            i = i - 1;
        }
        return (int) i;
    }
}
