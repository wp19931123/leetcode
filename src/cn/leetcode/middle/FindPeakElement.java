package cn.leetcode.middle;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.print(new FindPeakElement().findPeakElement(arr));
    }

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        return findPeakElement(nums,l,r);
    }

    public int findPeakElement(int[] nums,int l, int r) {
        if(l == r) {
            return l;
        }
        int mid = l + (r-l)/2;
        if(nums[l]> nums[l+1]) {
            return l;
        }
        if(nums[r] > nums[r-1]) {
            return r;
        }
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
            return mid;
        }else if(nums[mid] < nums[mid-1]) {
            return findPeakElement(nums,l,mid);
        }else{
            return findPeakElement(nums,mid,r);
        }
    }
}
