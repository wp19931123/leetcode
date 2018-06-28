package cn.leetcode.middle;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * nums = [0,0,1,1,1,1,2,3,3],
 * 返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new RemoveDuplicates().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {/**说明重复数超过2个*/
                    continue;//继续执行for循环，避免使用break
                }

            } else {/**如果出现不同，将 count 赋值为1*/
                count = 1;
            }/** idx 为去重之后的数组索引*/
            nums[idx] = nums[i];
            idx++;
        }

        return idx;
    }
}
