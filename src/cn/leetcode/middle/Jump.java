package cn.leetcode.middle;

import java.util.Arrays;

/**
 * 转态转换方程为：
 * dp[i]=min{dp[j]+1} and j+A[j]≥i, for 0≤j≤i−1
 */
public class Jump {

    public int jump(int[] A) {
        if (A == null) {
            return -1;
        }
        int len = A.length;
        int[] dp = new int[len];
        Arrays.fill(dp,len);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len - 1];
    }
    //贪心
    public int jump2(int [] A) {
        int jumps = 0;  //当前已经跳跃的步数
        int curEnd = 0; //当前位置能够跳跃的最远距离
        int curFarthest = 0; //在[0, curEnd]范围内的位置，能够跳跃的最远距离

        for (int i = 0; i < A.length-1; ++i) {
            curFarthest = Math.max(curFarthest, i+A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curFarthest >= A.length-1) return jumps;
            }
        }
        return curFarthest >= A.length-1 ? jumps : -1;
    }

}
