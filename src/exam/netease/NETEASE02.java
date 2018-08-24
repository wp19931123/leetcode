package exam.netease;

import java.util.Scanner;

public class NETEASE02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] str1 = sc.nextLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]);
            }

            int m = Integer.parseInt(sc.nextLine());
            String[] str2 = sc.nextLine().split(" ");
            int[] q = new int[m];
            for (int i = 0; i < m; i++) {
                q[i] = Integer.parseInt(str2[i]);
            }

            getResult(n, a, m, q);
        }
    }

    private static void getResult(int n, int[] a, int m, int[] q) {
        int[] sum = new int[n];
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            sum[i] = tmp + a[i];
            tmp += a[i];
        }

        for (int i = 0; i < m; i++) {
            System.out.println(find(sum, sum.length, q[i]) + 1);
        }
    }

    private static int find(int arr[], int size, int x) {        //二分查找-x第一次出现
        if (arr[size - 1] < x) {
            return -1;
        }
        int mid, low = 0, high = size - 1;
        while (low < high) {
            mid = (high + low) / 2;
            if (x <= arr[mid]) high = mid;
            else low = mid + 1;
        }
        return low;
    }

}
