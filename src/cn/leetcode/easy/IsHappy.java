package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.print(new IsHappy().isHappy(3));
    }

    public boolean isHappy(int n) {
        //为了判别有没有死循环，对于每一个出现的数字都记录下来，只要重复出现就是死循环
        List<Integer> list = new ArrayList<>();
        while(n != 1) {
            if(list.contains(n)) {
                return false;
            }
           list.add(n);
           n = pingf(n);
       }
        return true;
    }
    public static int pingf(int a) {
        int sum = 0;
        while(a != 0) {
            int m = a%10;
            sum += (Math.pow(m,2));
            a /= 10;
        }
        return sum;
    }
}
