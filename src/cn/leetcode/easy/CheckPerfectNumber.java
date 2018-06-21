package cn.leetcode.easy;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 */
public class CheckPerfectNumber {

    public static void main(String[] args) {
        System.out.println(new CheckPerfectNumber().checkPerfectNumber(28));
    }
    //超时
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) {
            return false;
        }
        int sum = 1;
        //求出所有正因子
        int n = (int)Math.sqrt(num);
        for(int i = n;i > 1;i--) {
            if(num % i == 0)  {
                sum = sum + i + num/i;
            }
        }
        return sum == num ? true : false;
    }
}
