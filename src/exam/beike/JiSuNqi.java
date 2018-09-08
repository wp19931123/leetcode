package exam.beike;

import java.util.Scanner;

public class JiSuNqi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int res = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            while (M > N) {
                if (M % 2 == 0) {
                    M = M / 2;
                } else {
                    M = (M + 1) / 2;
                    res++;
                }
                res = res + 1;
            }
            res = res + N - M;
            System.out.println(res);
        }
    }
}