package cn.leetcode.middle;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。
 * 如果不存在符合条件的子数组，返回 0。
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 进阶:
 * 如果你已经完成了O(n^2) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.print(new MinSubArrayLen().minSubArrayLen(11, nums));
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            if (cur < s) {
                cur += nums[r++];
            } else {
                if (r - l < res) {
                    res = r - l;
                }
                cur -= nums[l++];
            }
        }
        //r已经加到最后了，这时需要将l尽可能的往右移
        while(cur >= s) {
            cur -= nums[l++];
            if (r - l + 1 < res) {
                res = r - l + 1;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                for (int k = j; k <= i; k++) {
                    sum += nums[j];
                }
                if (sum >= s) {
                    if (i - j + 1 < res) {
                        res = i - j + 1;
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
