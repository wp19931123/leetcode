package cn.leetcode.easy;

/**
 * Remove Duplicates from Sorted Array
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A =[1,1,2],
 * Your function should return length =2, and A is now[1,2].
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3,3,3,4,5,5};
        System.out.println(new RemoveDuplicates().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        for(int i = 1;i < nums.length;i++) {
            //如果相等,移动count位
            if(nums[i] == nums[i-1]) {
               continue;
            }else{
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
