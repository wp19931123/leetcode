package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4,2));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return res;
        }
        dfs(1, k, n, new ArrayList<>());
        return res;
    }

    private void dfs(int start, int k, int n, List<Integer> tmp) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(i + 1, k - 1, n, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
