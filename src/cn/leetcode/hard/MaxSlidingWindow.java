package cn.leetcode.hard;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * 进阶：你能在线性时间复杂度内解决此题吗？
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    //双向队列: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //队头下标等于最左边数的下标，扔掉
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.poll();
            }
            //把队列尾部比新数小的都扔掉，保证队列是降序的
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            //加入新数
            dq.offerLast(i);
            //队列头部就是窗口内第一大的
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[dq.peek()];
            }
        }
        return res;
    }

    //最大堆 时间复杂度： O(nlogk)
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                pq.remove(nums[i - k]); //移除最左边的数字
            }
            pq.add(nums[i]);  //添加新数
            if (i + 1 >= k) {
                res[i - k + 1] = pq.peek();
            }
        }

        return res;
    }

    //暴力：时间复杂度: O(nk)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
