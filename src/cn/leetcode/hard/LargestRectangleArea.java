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
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.print(new LargestRectangleArea().largestRectangleArea2(nums));
    }

    /**
     * 单调栈解法，从每个位置开始向两边寻找第一个比自己小的数字
     */
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

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int j = stack.pop();  //i使得j弹出，j的右边界就是i
                int k = stack.isEmpty() ? -1 : stack.peek(); //k是j的左边界
                int curArea = (i - k - 1) * heights[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);  //i入栈，栈下面都是比i位置大的数字了，保持递增
        }
        //被动出栈，右边界就是数组右边界
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek(); //左边界
            int curArea = (heights.length - k - 1) * heights[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
