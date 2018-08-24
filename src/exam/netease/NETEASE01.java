package exam.netease;

import java.util.Scanner;

/**
 * n: 课堂的时间
 * k: 叫醒小易可以保持不睡的时间，只可以叫醒一次
 * v: 对每分钟知识点的感兴趣评分
 * t：表示每分钟小易是否清醒
 */
public class NETEASE01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();  //叫醒xiaoyi能够保持清醒的时间
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        System.out.println(getMaxPoints(n, k, v, t));
        sc.close();
    }

    public static int getMaxPoints(int n, int k, int[] v, int[] t) {
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                val += v[i];
            }
        }

        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            int total = 0;
            for (int j = i; j < i + k; j++) {
                if (t[j] != 1) {
                    total += v[j];
                }
            }
            max = Math.max(max, total);
        }
        return val + max;
    }


//    public static void main(String[] args) {
//        int[] v = {1, 3, 5, 2, 5, 4};
//        int[] t = {1, 1, 0, 1, 0, 0};
//        System.out.print(getMaxPoints(6, 3, v, t));
//    }
}
