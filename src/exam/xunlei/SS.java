package exam.xunlei;

import java.util.Scanner;

public class SS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(getMaxSum(A, B));
        }
        sc.close();
    }

    public static int getMaxSum(int A, int B) {
        int res;
        int index = 0;
        for (int i = 1; i <= 7; i++) {
            if (B * i + A * (7 - i) < 0) {
                index = 7 - i;
                break;
            }
        }
        int count = A * index + B * (7 - index);
        if (index >= 3) {
            res = 3 * A + count * 2;
        } else {
            res = A * index + (3 - index) * B + count * 2;
        }
        return res;

    }

}
