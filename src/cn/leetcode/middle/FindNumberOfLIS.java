package cn.leetcode.middle;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 7};
        System.out.print(new FindNumberOfLIS().findNumberOfLIS(array));
    }

    /**
     * 在迭代数组时维护这两个数组，并且通过这两个数组累加最长序列个数
     * len[i],存放以i为递增序列尾部元素的最长序列长度(注意是最长序列)
     * cnt[i],存放以i为递增序列尾部元素的最长序列个数(注意是最长序列)
     * 令当前最长序列长度为maxlen,令当前最长序列个数为maxcount
     * 当maxlen == length[i] 时,maxcount += count[i]
     * 当maxlen < length[i]时,maxlen = length[i],maxcount = count[i]
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];

        for (int i = 0; i < n; i++) {
            //一定要注意这里的初始化
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) {
                res += cnt[i];
            }
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }

        return res;
    }
}
