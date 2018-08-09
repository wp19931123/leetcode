package cn.leetcode.middle;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new ProductExceptSelf().productExceptSelf3(nums);
        for (int r : res) {
            System.out.println(r + " ");
        }
    }
    //进阶
    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++)  //①
            res[i] = res[i - 1] * nums[i - 1];
        for (int i = nums.length - 2, mul = nums[i + 1]; i >= 0; i--) {  //②
            res[i] *= mul;
            mul *= nums[i];
        }
        return res;
    }

    //申请两个大小为 n 的数组
    //1. 第一个数组的第 i 个元素存储第0个到第 i-1 个元素的乘积
    //2. 第二个数组的第 i 个元素存储第 i+1 到最后一个元素的乘积
    public int[] productExceptSelf3(int[] nums) {
        int[] p1 = new int[nums.length];
        int[] p2 = new int[nums.length];
        p1[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            p1[i] = p1[i - 1] * nums[i - 1];
        }
        p2[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            p2[i] = p2[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            p1[i] *= p2[i];
        }
        return p1;
    }

    //超出时间限制 O(n^2)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int l = -1;
        int r = 1;
        int p1 = 1;
        int p2 = 1;
        for (int i = 0; i < len; i++) {
            if (l >= 0) {
                p1 = product(nums, 0, l);
            }
            if (r < len) {
                p2 = product(nums, r, len - 1);
            }
            res[i] = p1 * p2;
            p1 = p2 = 1;
            l++;
            r++;
        }
        return res;
    }

    private int product(int[] nums, int l, int r) {
        int res = 1;
        for (int i = l; i <= r; i++) {
            res *= nums[i];
            if (res == 0) {
                return 0;
            }
        }
        return res;
    }
}
