package exam.other;

import java.util.Scanner;

public class HuanJu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String S = sc.next();
            String T = sc.next();
            if (S.length() == T.length()) {
                String he = S + S;
                int index = he.indexOf(T);
                if (index == -1) {
                    System.out.println(false);
                    continue;
                }
                System.out.println(true);
                continue;
            }
            System.out.println(false);
            continue;
        }
    }

    private static int getSum(String s1) {
        int sum = 0;
        for (char c : s1.toCharArray()) {
            sum += Integer.valueOf(c) * Integer.valueOf(c) * Integer.valueOf(c) + 100;
        }
        return sum;
    }
}
