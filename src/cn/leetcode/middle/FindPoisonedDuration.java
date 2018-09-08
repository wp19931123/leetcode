package cn.leetcode.middle;

/**
 * 提莫攻击:中毒时间不可而叠加，求中毒的总时长
 */
public class FindPoisonedDuration {

    /**
     * @param timeSeries： 释放毒的时间点
     * @param duration:   每次中毒的持续时间
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 1;i < timeSeries.length;i++) {
            if(timeSeries[i] - timeSeries[i-1] > duration) {
                res += duration;
            }else{
                res += timeSeries[i] - timeSeries[i-1];
            }
        }
        res += duration;
        return res;
    }

    public static void main(String[] args) {
        int[] timeSeries1 = {1, 4};
        int[] timeSeries2 = {1, 2};
        System.out.println(new FindPoisonedDuration().findPoisonedDuration(timeSeries1, 2));  //4
        System.out.println(new FindPoisonedDuration().findPoisonedDuration(timeSeries2, 2));  //3
    }
}
