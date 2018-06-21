package cn.leetcode.easy;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3,3,3,4,5,5};
        System.out.println(new RemoveElement().removeElement(arr,3));
    }
    public int removeElement(int[] nums, int val) {
        int end = nums.length;
        for(int i = 0;i < end;i++) {
            if(nums[i] == val) {
                while(nums[--end] == val && i < end);
                nums[i] = nums[end];
            }
        }
        return end;
    }
}
