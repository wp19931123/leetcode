package cn.leetcode.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:[[1,1,2],[1,2,1],[2,1,1]]
 */
public class PermuteUnique {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        List<List<Integer>> res = new PermuteUnique().permuteUnique(arr);
        System.out.println(res);
    }

    List<List<Integer>> res;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        res = new LinkedList<>();
        used = new boolean[nums.length];
        if (nums == null || len == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> tmp = new LinkedList<>();
        helper(nums, tmp);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp){
        if(tmp.size() == nums.length){
            List<Integer> list = new LinkedList<>(tmp);
            res.add(list);
        } else {
            for(int idx = 0; idx < nums.length; idx++){
                // 遇到已经加过的元素就跳过
                if(used[idx]){
                    continue;
                }

                // 加入该元素后继续搜索
                used[idx] = true;
                tmp.add(nums[idx]);
                helper(nums, tmp);
                tmp.remove(tmp.size()-1);
                used[idx] = false;
                // 跳过本轮的重复元素，确保每一轮只会加unique的数字
                while(idx < nums.length - 1 && nums[idx] == nums[idx + 1]){
                    idx++;
                }
            }
        }
    }
}
