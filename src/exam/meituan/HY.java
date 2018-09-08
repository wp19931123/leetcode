package exam.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class HY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i] = new int[]{
                    sc.nextInt(), sc.nextInt()
            };
        }
        int[] tmp = findonnection(edges);
        if (tmp == null || tmp.length == 0) {
            return;
        }
        if (tmp[0] == 1 || tmp[1] == 1) {
            System.out.println(n + 1);
        } else {
            System.out.println(2 * n + 1);
        }
    }


    public static int[] findonnection(int[][] edges) {
        int[] in = new int[edges.length + 4];
        boolean has2parent = false;
        int[] has2parentPos = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int[] t = edges[i];
            in[t[1]]++;
            if (in[t[1]] == 2) {
                has2parent = true;
                has2parentPos[1] = i;
                for (int j = 0; j < i; j++)
                    if (edges[j][1] == t[1]) {
                        has2parentPos[0] = j;
                        break;
                    }
                break;
            }
        }

        int[] ret = findRedCon(edges, -1);

        if (!has2parent) return ret;
        if (ret == null) return edges[has2parentPos[1]];
        if (findRedCon(edges, has2parentPos[0]) == null)
            return edges[has2parentPos[0]];
        else
            return edges[has2parentPos[1]];
    }

    public static int[] findRedCon(int[][] edges, int p) {
        int[] root = new int[edges.length + 4];
        for (int i = 0; i < root.length; i++) root[i] = i;

        for (int q = 0; q < edges.length; q++) {
            if (p == q) continue;
            int i = edges[q][0], j = edges[q][1];

            for (int k = 0; k < root.length; k++) {
                if (root[k] == j)
                    root[k] = root[i];
            }

            if (root[i] == j) return edges[q];
        }
        return null;
    }
}
