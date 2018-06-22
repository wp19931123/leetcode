package cn.leetcode.middle;

public class MaxArea {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l < r) {
            int lv = height[l];
            int rv = height[r];
            if(Math.min(lv,rv)*(r-l) > max) {
                max = Math.min(lv,rv)*(r-l);
            }
            if(lv < rv) {
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
