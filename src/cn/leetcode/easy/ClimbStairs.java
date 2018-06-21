package cn.leetcode.easy;

public class ClimbStairs {

    //递归，超时
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n ==2 ) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        if(n <= 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        int res = 0;
        for(int i = 3; i <= n;i++) {
            res = one + two;
            one = two;
            two = res;
        }

        return res;
    }
}
