package exam.bianlifeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(",");
        int m = Integer.valueOf(strs[0]);
        int n = Integer.valueOf(strs[1]);
        System.out.println(new Main3().combine(n,m));
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
