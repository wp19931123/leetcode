package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * 示例 1:
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElement {

    /**
     * 限定了时间和空间复杂度，所以不能排序，也不能使用哈希表
     * 摩尔投票法 Moore Voting
     * 摩尔投票法思想：
     * 每次从数组中选择两个不相等的元素进行相互抵消(删除)，最后剩下的一个元素或几个相同的元素就是出现次数大于n/2的元素
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int m = 0, n = 0, cm = 0, cn = 0;
        //第一次遍历得到两个最多的数字
        for (int a : nums) {
            if (a == m) {
                ++cm;
            } else if (a == n) {
                ++cn;
            } else if (cm == 0) {
                m = a;
                cm = 1;
            } else if (cn == 0) {
                n = a;
                cn = 1;
            } else {
                --cm;
                --cn;
            }
        }
        //第二次遍历计算这两个数各自出现的次数
        cm = cn = 0;
        for (int a : nums) {
            if (a == m) {
                ++cm;
            } else if (a == n) {
                ++cn;
            }
        }
        //验证是不是超过n/3
        if (cm > nums.length / 3) {
            res.add(m);
        }
        if (cn > nums.length / 3) {
            res.add(n);
        }
        return res;
    }
}
