package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 所有数字（包括 target）都是正整数。解集不能包含重复的组合。
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] can = {2,3,6,7};
        List<List<Integer>> res = new CombinationSum().combinationSum(can,7);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(candidates == null) {
            return res;
        }
        combinationSum(candidates,0,target,tmp,res);
        return res;
    }

    private void combinationSum(int[] candidates, int start, int target, List<Integer> tmp, List<List<Integer>> res) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start;i < candidates.length;i++) {
            tmp.add(candidates[i]);
            combinationSum(candidates,i,target-candidates[i],tmp,res);
            tmp.remove(tmp.size()-1);
        }
    }
    
    //采用深度优先搜索的思想+回溯(可以不排序，并去掉剪枝)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        // 排序可以避免重复，结果可以按照顺序输出  
        Arrays.sort(candidates);
        dfsCore(candidates, 0, 0, target, tmp,res);
        return res;

    }

    private void dfsCore(int[] candidates,int curIdx, int sum, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = curIdx; i < candidates.length; i++) {
            // 剪枝，可以没有，目的为了优化，必须先排序
            if (target < candidates[i])
                return;
            sum += candidates[i];
            // 剪枝，可以没有，目的为了优化，必须先排序
            if (target < sum)
                return;

            tmp.add(candidates[i]);
            // 之所以不传i+1的原因是：
            // The same repeated number may be
            // chosen from C unlimited number of time
            dfsCore(candidates, i, sum, target,tmp, res);
            tmp.remove(tmp.size() - 1);
            // 回溯
            sum -= candidates[i];
        }
    }
}
