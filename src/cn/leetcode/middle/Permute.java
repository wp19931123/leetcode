package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = new Permute().permute(arr);
        System.out.print(res);
    }

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int len = nums.length;
        return allSort(nums, 0, len - 1, res);
    }

    /**
     * 1.首先将1固定，递归求子数组[2,3]的全排列；
     * 2.将1和2交换，递归求[1,3]的全排列；
     * 3.因为第二步中1和2进行了交换，因此需要再把1交换回来，交换回来之后再将1和3进行交换，再递归求[1,2]的全排列。
     *
     * @param nums
     * @param begin
     * @param end
     * @param list
     * @return
     */
    private List<List<Integer>> allSort(int[] nums, int begin, int end, List<List<Integer>> list) {
        if (begin == end) {
            List<Integer> tmp = new ArrayList();
            for (int i : nums) {
                tmp.add(i);
            }
            list.add(tmp);
            return list;
        }
        for (int i = begin; i <= end; i++) {
            swap(nums, begin, i);
            allSort(nums, begin + 1, end, list);
            swap(nums, begin, i);
        }
        return list;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //交换法
    public List<List<Integer>> permute2(int[] nums) {
        res = new LinkedList<>();
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i) {
        // 找到转置完成后的解，将其存入列表中
        if (i == nums.length - 1) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            helper(nums, i + 1);
            swap(nums, i, j);
        }
    }

    boolean[] used;

    //DFS  每一轮搜索选择一个数加入列表中，
    // 同时我们还要维护一个全局的布尔数组，来标记哪些元素已经被加入列表了
    public List<List<Integer>> permute3(int[] nums) {
        res = new LinkedList<>();
        used = new boolean[nums.length];
        List<Integer> tmp = new LinkedList<>();
        helper(nums, tmp);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            List<Integer> list = new LinkedList<>(tmp);
            res.add(list);
        } else {
            for (int idx = 0; idx < nums.length; idx++) {
                // 遇到已经加过的元素就跳过
                if (used[idx]) {
                    continue;
                }
                // 加入该元素后继续搜索
                used[idx] = true;
                tmp.add(nums[idx]);
                helper(nums, tmp);
                tmp.remove(tmp.size() - 1);
                used[idx] = false;
            }
        }
    }
}
