package cn.leetcode.middle;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。
 * 编写一个方法，计算出研究者的 h 指数。
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 说明:如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * 进阶：
 * 这是 H指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 */
public class hIndexII {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        for(int i = len-1;i >= 0;i--) {
            if(len-i > citations[i]) {
                return len-i-1;
            }
        }

        return len;
    }
}
