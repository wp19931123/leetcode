package cn.leetcode.middle;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 */
public class FindMin {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.print(new FindMin().findMin(arr));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("err");
        }
        int l = 0;
        int r = nums.length - 1;
        return findMin(nums, l, r);
    }

    public int findMin(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] >= nums[l]) { //前半段是递增的，最小值是前半段最小的和递归后半段之最小
            return Math.min(findMin(nums, mid + 1, r), nums[l]);
        } else {  //后半段是递增的，只需要求从头到mid
            return findMin(nums, l, mid);
        }
    }
}
