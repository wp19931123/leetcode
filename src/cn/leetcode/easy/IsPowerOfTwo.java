package cn.leetcode.easy;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        if(n < 1) {
            while(n < 1) {
                n *= 2;
            }
        }else if(n > 1) {
            while(n % 2 == 0) {
                n /= 2;
            }
        }
        return n == 1 ? true : false;
    }
}
