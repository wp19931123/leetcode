package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 示例 1:
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> res = new SummaryRanges().summaryRanges(nums);
        System.out.println(res);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                if (i == nums.length - 1) {
                    res.add(nums[l] + "->" + nums[i]);
                }
            } else {
                //判断是一个数字还是一个序列
                if (i - l == 1) {
                    res.add(nums[l] + "");
                } else {
                    res.add(nums[l] + "->" + nums[i - 1]);
                }
                //左边界重新开始
                l = i;
                if (i == nums.length - 1) {
                    res.add(nums[i] + "");
                }
            }
        }
        return res;
    }

    /**
     * 每次检查下一个数是不是递增的，如果是，则继续往下遍历，如果不是了，我们还要判断此时是一个数还是一个序列，
     * 一个数直接存入结果，序列的话要存入首尾数字和箭头“->"。我们需要两个变量i和j，
     * 其中i是连续序列起始数字的位置，j是连续数列的长度，当j为1时，说明只有一个数字，若大于1，则是一个连续序列
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int j = 1;
            while (i + j < n && nums[i + j] - nums[i] == j) {
                ++j;
            }
            res.add(j <= 1 ? Integer.toString(nums[i]) : Integer.toString(nums[i]) + "->" + Integer.toString(nums[i + j - 1]));
            i += j;
        }
        return res;
    }

    //双指针法
    public List<String> summaryRanges3(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] - nums[right - 1] != 1) {
                if (right - 1 - left == 0) {
                    res.add(nums[right - 1] + "");
                } else if (right - 1 - left > 0) {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;

                if (right == nums.length - 1) {
                    res.add(nums[right] + "");
                }
            } else {
                if (right == nums.length - 1) {
                    res.add(nums[left] + "->" + nums[right]);
                }
            }
            right++;
        }

        return res;
    }
}
