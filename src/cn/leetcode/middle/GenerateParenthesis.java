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

    /**
     * 如果左括号还能括就不断的画左括号，直到左括号的数量等于n。
     * 接下来考虑右括号，因为对于一对括号，右括号不能出现在左括号前，所以当右括号数量小于左括号时，加上右括号。
     * 当左右括号数量都等于n时，得到解。
     * @param left
     * @param right
     * @param buffer
     * @param strings
     * @param n
     */
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
