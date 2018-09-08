package exam.qi360;

import java.util.Scanner;

public class QiHu1 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();  //居民个数
//        int[][] arr = new int[N][2];
//        for(int i = 0; i < N;i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        //求城市的最小面积
//        System.out.println(minCity(arr,N));
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int num = s.nextInt();
            long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE, maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;
            long[] Y = new long[num];
            for (int i = 0; i < num; i++) {
                long x = s.nextLong(), y = s.nextLong();
                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
            }
            if ((maxX - minX) > (maxY - minY)) {
                System.out.println((maxX - minX) * (maxX - minX));
            } else {
                System.out.println((maxY - minY) * (maxY - minY));
            }
        }
    }

    private static int minCity(int[][] arr, int N) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            l = Math.min(l, arr[i][0]);
            r = Math.max(r, arr[i][0]);
            up = Math.max(up, arr[i][1]);
            down = Math.min(down, arr[i][1]);
        }
        int m1 = r - l;
        int m2 = up - down;
        int m = Math.max(m1, m2);
        return m*m;
    }
}
