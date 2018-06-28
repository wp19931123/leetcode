package cn.leetcode.middle;

import cn.leetcode.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] can = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = new CombinationSum2().combinationSum2(can, 8);
        System.out.println(res);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);  //排序 避免重复
        combinationSum2(candidates, 0, target, tmp, res);
        return res;
    }

    private void combinationSum2(int[] candidates, int begin, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (begin >= candidates.length || target < 0 || candidates[begin] > target) {
            return;
        }
        for (int i = begin; (i < candidates.length) && (candidates[i] <= target); i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.add(candidates[i]);
            combinationSum2(candidates, i + 1, target - candidates[i], tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

}
