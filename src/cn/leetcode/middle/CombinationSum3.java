package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        System.out.print(new CombinationSum3().combinationSum3(1,1));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (n < 1 || n > 45 || k < 1 || k > 10 || k > n) {
            return res;
        }
        dfs(res, 1, 0, tmp, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, int curIdx, int sum, List<Integer> tmp, int n, int k) {
        if (sum > n)
            return;
        if (k < 0)
            return;
        if (sum == n && k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // For循环每次从curIdx开始，避免返回到之前的元素
        for (int i = curIdx; i < 10; i++) {
            // 剪枝
            if (n < sum)
                return;
            sum += i;
            tmp.add(i);
            // 传入i+1
            //注意直接i++和在函数中使用i+1的区别
            i++;
            dfs(res, i, sum, tmp, n, k - 1);
            // 回溯
            i--;
            tmp.remove(tmp.size() - 1);
            sum -= i;
        }

    }
}
