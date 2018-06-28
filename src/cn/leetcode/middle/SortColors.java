package cn.leetcode.middle;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 不能使用代码库中的排序函数,你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    //快排思想
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = -1;
        int right = len;
        int i = 0;
        while(i < right) {
            if(nums[i] > 1) {
                swap(nums,i,--right);
            }else if(nums[i] < 1) {
                swap(nums,i++,++left);
            }else{
                i++;
            }
        }
    }
    private void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
