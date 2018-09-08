package exam.beike;

import java.util.Scanner;

public class YiChuan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pre = new int[100005];
        for (int i = 1; i <= n; i++)
            pre[i] = 0;
        for (int i = 1; i <= n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (num2 == -1)
                pre[num1] = num1;
            else
                join(num1, num2, pre);
        }

        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (find(num2, num1, pre))
                System.out.println(1);
            else if (find(num1, num2, pre))
                System.out.println(2);
            else
                System.out.println(0);
        }
    }

    public static boolean find(int x, int old, int[] pre) {
        int r = x;
        while (pre[r] != r) {
            if (pre[r] == old)
                return true;
            r = pre[r];
        }
        return false;
    }

    public static int find(int x, int[] pre) {
        int r = x;
        while (pre[r] != r)
            r = pre[r];
        return r;
    }

    public static void join(int x, int y, int[] pre) {
        int fx = find(x, pre);
        int fy = find(y, pre);
        if (fx != 0)
            pre[y] = x;
        else
            pre[x] = y;
    }
}