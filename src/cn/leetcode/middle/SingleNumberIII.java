package cn.leetcode.middle;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] res = new SingleNumberIII().singleNumber(nums);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] singleNumber(int[] nums) {
        int yh = 0;
        for (int i = 0; i < nums.length; i++) {
            yh ^= nums[i];
        }
        //找出a^b中第一个为1的位置
        int index = findFirst1(yh);
        int s1 = 0, s2 = 0;
        for (int i = 0; i < nums.length; i++) {
            //判断每个数字的第index位是0是1
            if (is1(nums[i], index)) {
                s1 ^= nums[i];
            } else {
                s2 ^= nums[i];
            }
        }
        return new int[]{s1, s2};
    }

    private boolean is1(int num, int index) {
        for (int i = 0; i < index; i++) {
            num >>= 1;
        }
        if ((num & 1) == 1) {
            return true;
        }
        return false;
    }

    private int findFirst1(int num) {
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                return index;
            }
            index++;
            num >>= 1;
        }
        return index;
    }
}
