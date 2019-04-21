package exam.jd;

import java.util.Scanner;

public class Main1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();  //输入样例个数
        while (num-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[][] nodes = new boolean[n][n];
            while (m-- > 0) {
                int i = sc.nextInt() - 1;
                int j = sc.nextInt() - 1;
                nodes[i][j] = true;
                nodes[j][i] = true;
            }
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nodes[i][j]) {
                        result[i]++;
                    }
                }
            }
            boolean flag = true;
            flag = isFlag(n, nodes, result, flag);
            if (!flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean isFlag(int n, boolean[][] nodes, int[] result, boolean flag) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (!nodes[i][j]) {
                    if (result[i] != result[j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }
}
