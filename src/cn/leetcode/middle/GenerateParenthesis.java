package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(0, 0, "", res, n);

        return res;
    }

    private void dfs(int left, int right, String buffer, ArrayList<String> strings, int n) {
        if (left == n && right == n) {
            strings.add(buffer);
            return;
        }

        if (left < n) {
            dfs(left + 1, right, buffer + "(", strings, n);
        }

        if (left > right) {
            dfs(left, right + 1, buffer + ")", strings, n);
        }
    }
}
