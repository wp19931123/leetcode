package exam.CMBCard;

import java.util.Scanner;

//鸡鸭移动位置
public class CMBCard1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int C = 0;
        int indexSumC = 0;

        char[] chs = str.toCharArray();
        int n = chs.length;
        for (int i = 0; i < n; i++) {
            if (chs[i] == 'C') {
                C++;
                indexSumC += i;
            }
        }
        int D = n - C;
        int indexSumD = (n - 1) * n / 2 - indexSumC;
        int diffC = indexSumC - (C - 1) * C / 2;
        int diffD = indexSumD - (D - 1) * D / 2;
        int res = Math.min(diffC, diffD);
        System.out.println(res);
    }

}
