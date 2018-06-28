package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Subsets().subsets(arr));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return res;
        }
        int len = nums.length;
        dfs(nums, 0, len, new ArrayList<>());
        return res;
    }

    //原数组中每一个元素在子集中有两种状态：要么存在、要么不存在。
    // 这样构造子集的过程中每个元素就有两种选择方法：选择、不选择，因此可以构造一颗二叉树来表示所有的选择状态
    private void dfs(int[] nums, int begin, int len, ArrayList<Integer> tmp) {
        if (begin == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        //不将元素加入到temp中
        dfs(nums, begin + 1, len, tmp);
        //将元素加入到temp中
        tmp.add(nums[begin]);
        dfs(nums, begin + 1, len, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
