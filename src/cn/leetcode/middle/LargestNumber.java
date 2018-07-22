package cn.leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        String res = "";
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        int count = 0;
        for (int i : nums) {
            strs[count++] = Integer.toString(i);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String s : strs) {
            res += s;
        }
        //去掉前面多余的0
        int zero = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '0') {
                zero++;
            } else {
                break;
            }
        }

        if (zero > 1) {
            return res.substring(zero - 1);
        }
        return res;
    }
}
