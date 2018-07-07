package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(new SubsetsWithDup().subsetsWithDup(arr));
    }


    boolean flag[];
    List<List<Integer>> result;

    /**
     * 0、首先需要排序，然后用回溯的方式组合选择，序列在递归到最后一个位置时生成。
     * 规则0：所有数都有不选的这种状况
     * 规则1：第一个数（index=0）可以选
     * 规则2：在任何情况下，当一个数（位置index）和前一个数（index-1）的数值不相同时，可以选中，也可以不选中
     * 规则3：任何情况下，当一个数（位置index）和前一个数（index-1）的数值相同时，当且仅当index-1的数字被选中了，index才能被选中，否则index不能选中
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.flag = new boolean[nums.length];
        result = new ArrayList<>();
        search(nums, 0, new ArrayList<>());

        return result;
    }

    private void search(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < index; i++) {
                if (flag[i] == true) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
            return;
        }
        search(nums, index + 1);
        if (index == 0 || nums[index - 1] != nums[index] || flag[index - 1] == true) {
            flag[index] = true;
            search(nums, index + 1);
            flag[index] = false;
        }
    }

    private void search(int[] nums, int index, List<Integer> tmp) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        search(nums, index + 1, tmp);
        if (index == 0 || nums[index - 1] != nums[index] || flag[index - 1] == true) {
            tmp.add(nums[index]);
            flag[index] = true;
            search(nums,index + 1,tmp);
            tmp.remove(tmp.size() - 1);
            flag[index] = false;
        }
    }
}
