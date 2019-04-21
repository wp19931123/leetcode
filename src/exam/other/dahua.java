package exam.other;

import java.util.Scanner;

public class dahua {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(rev(rev(100) + rev(322)));
    }

    public static int rev(int n) {
        String str = Integer.valueOf(n).toString();
        char[] chs = str.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l < r) {
            swap(chs, l, r);
            l++;
            r--;
        }
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chs.length; i++) {
            if (chs[0] == '0') {
                while (chs[i] == '0') {
                    i++;
                }
            }
            sb.append(chs[i]);
        }
        int res = Integer.valueOf(sb.toString());
        return res;
    }

    private static void swap(char[] chs, int l, int r) {
        char tmp = chs[l];
        chs[l] = chs[r];
        chs[r] = tmp;
    }
}
