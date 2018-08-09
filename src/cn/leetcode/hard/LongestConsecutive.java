package cn.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]   输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.print(new LongestConsecutive().longestConsecutive(nums));
    }

    //所有数放入set中，再遍历数组每个数字，如果set中存在则移除
    //并计算前一个数和后一个数，并看set集合是否存在
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1;
                int next = num + 1;
                while (s.remove(pre)) {
                    pre--;
                }
                while (s.remove(next)) {
                    next++;
                }
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }

    //哈希表
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) {
                continue;
            }
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;
            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }
        return res;
    }
}
