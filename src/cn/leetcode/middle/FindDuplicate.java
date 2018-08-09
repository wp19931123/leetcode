package cn.leetcode.middle;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]  输出: 2
 * 说明：不能更改原数组（假设数组是只读的）。只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n^2) 。数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(new FindDuplicate().findDuplicate(arr));
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
