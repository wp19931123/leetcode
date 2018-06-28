package cn.leetcode.middle;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Search {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(new Search().search(arr,1));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        //二分查找
        int l = 0;
        int r = len-1;
        while(l <= r) {
           int mid = l + (r-l)/2;
           if(nums[mid] == target) {
               return mid;
           }
           if(nums[mid] >= nums[l]) {
               if(nums[mid] > target && nums[l] <= target) {
                   r = mid - 1;
               }else{
                   l = mid + 1;
               }
           }else{
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
           }
        }
        return -1;
    }
}
