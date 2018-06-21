package cn.leetcode.easy;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 */
public class RotatedDigits {

    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        while(N > 0) {
            if(isGoodNum(N--)) {
                count++;
            }
        }
        return count;
    }

    public boolean isGoodNum(int n) {
        int count2569 = 0;
        while(n > 0) {
            if(n % 10 == 3 || n % 10 == 4 || n % 10 == 7) {
                return  false;
            }else if(n % 10 == 2 || n % 10 == 5 || n % 10 == 6 || n % 10 == 9) {
                count2569++;
            }
            n /= 10;
        }
        return  count2569 == 0 ? false : true;
    }

}
