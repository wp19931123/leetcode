package exam.other;

import java.util.ArrayList;

public class HUAWEI02 {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);

        int[][] A = new int[5][2];
        int[][] B = new int[5][2];
        for (int i = 0; i < 5; i++) {
            A[i][0] = 1;
            A[i][1] = 1;
            B[i][0] = 1;
            B[i][1] = 1;
        }
//        for(int i = 0;i < 5;i++) {
//            A[i][0] = sc.nextInt();
//            A[i][1] = sc.nextInt();
//        }
//        for(int i = 0;i < 5;i++) {
//            B[i][0] = sc.nextInt();
//            B[i][1] = sc.nextInt();
//        }
        compu(A, B);
    }

    private static void compu(int[][] a, int[][] b) {
        for (int i = 0; i < 5; i++) {
            int t = 0;
            int v = 0;
            ArrayList<Integer> list1 = new ArrayList();
            ArrayList<Integer> list2 = new ArrayList();
            for (int j = 0; j <= i; j++) {
                t += (a[j][0] * b[i - j][0] - a[j][1] * b[i - j][1]);
                v += (a[j][1] * b[i - j][0] + a[j][0] * b[i - j][1]);
            }

            System.out.println(t);
            System.out.println(v);

        }

    }
}
