package cn.leetcode.middle;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 1};
        System.out.print(new SingleNumber().singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new RuntimeException("err");
        }
        int[] bit32 = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bit32[j] += 1;
                }
                bitMask <<= 1;
            }
        }
        int res = 0;
        for (int i : bit32) {
            res <<= 1;
            res += i % 3;
            System.out.print(res);
        }
        return res;
    }
}
