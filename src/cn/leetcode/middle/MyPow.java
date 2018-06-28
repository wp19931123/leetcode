package cn.leetcode.middle;

/**
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class MyPow {

    public double myPow(double x, int n) {
        if(n < 0) {
            return 1/pow(x,-n);
        }
        return pow(x,n);
    }

    //递归来折半
    private double pow(double x,int n) {
        if(n == 0) {
            return 1;
        }
        double half = pow(x,n/2);
        if(n % 2 == 0) {
            return half*half;
        }else{
            return x*half*half;
        }
    }

    /**
     * 迭代的解法，我们让i初始化为n，然后看i是否是2的倍数，是的话x乘以自己，否则res乘以x，
     * i每次循环缩小一半，直到为0停止循环,最后看n的正负，如果为负，返回其倒数
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}
