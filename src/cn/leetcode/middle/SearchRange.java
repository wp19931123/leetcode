package cn.leetcode.middle;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别.
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] res = new SearchRange().searchRange(arr,6);
        System.out.print(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int l = 0;
        int r = nums.length-1;
        if(nums[l] > target || nums[r] < target) {
            return new int[]{-1,-1};
        }
        while(l <= r) {
            if(nums[l] == target && nums[r] == target) {
                return new int[]{l,r};
            }
            int mid = l + (r - l)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            }else if(nums[mid] > target) {
                r = mid - 1;
            }else{
                while(nums[l] < target) {
                    l++;
                }
                while(nums[r] > target) {
                    r--;
                }
            }
        }

        return new int[]{-1,-1};
    }
}
