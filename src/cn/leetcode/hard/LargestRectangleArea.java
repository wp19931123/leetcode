package cn.leetcode.hard;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.print(new LargestRectangleArea().largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        int[] h = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            h[i] = heights[i];
        }
        h[heights.length] = 0;
        for (int i = 0; i < h.length; i++) {
            if (s.isEmpty() || h[s.peek()] < h[i]) {
                s.push(i);
            } else {
                int cur = s.pop();
                res = Math.max(res, h[cur] * (s.isEmpty() ? i : (i - s.peek() - 1)));
                i--;
            }
        }
        return res;
    }
}
