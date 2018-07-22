package cn.leetcode.extend;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> res = new NQueens().solveQueues(4);
        for(List<String> s : res) {
            for(String ss : s) {
                System.out.println(ss + " ");
            }
            System.out.println();
        }
    }

    List<List<String>> res;
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    /**
     * col保证纵方向不冲突
     * dia1保证斜线方向上不冲突，斜线上横纵坐标之和是一个定值
     * dial2保证反斜线方向上不冲突，反斜线上横坐标减去纵坐标是一个常数
     * @param n
     * @return
     */
    public List<List<String>> solveQueues(int n) {
        List<Integer> row = new ArrayList<>();
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n + 1];
        dia2 = new boolean[2 * n + 1];

        putQueue(n, 0, row);
        return res;
    }

    private void putQueue(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generator(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueue(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generator(int n, List<Integer> row) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = row.get(i);
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    tmp += "Q";
                } else {
                    tmp += ".";
                }
            }
            list.add(tmp);
        }
        return list;
    }

}
