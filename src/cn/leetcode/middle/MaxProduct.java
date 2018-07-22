package cn.leetcode.middle;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.print(new MaxProduct().maxProduct(arr));
    }

    /**
     * 动态规划思想
     * 每有一个新的数字加入，最大值要么是当前最大值*新数，要么是当前最小值（负数）*新数（负数），要么是新加值
     * 最小值要么是当前最大值*新数（负数），要么是当前最小值（负数）*新数，要么是新加值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("input err");
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
