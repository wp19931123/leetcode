package cn.leetcode.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }

    public int countPrimes(int n) {
        if(n <= 1) return 0;
        int[] index = new int[n];
        index[0] = index[1] = 1;
        int a = 2;
        while(a < n){
            while( a < n && index[a] == 1 ) a++;
            for(int temp = a * 2 ; temp < n ;temp = temp + a  ){
                index[temp] = 1;
            }
            a++;
        }
        int result = 0;
        for(int i = 2;i < n;i++){
            if(index[i] == 0) {
                result++;
            }
        }
        return result;
    }
}
