package exam.other;

import java.util.Scanner;

public class HUAWEI01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chs = str.toCharArray();
        int flag = 0;
        int res = 0;
        int pre = -1;
        for (int i = 0; i < chs.length; i++) {
            if (isNum(chs[i])) {
                pre = i;
                while (i < chs.length && isNum(chs[i])) {
                    i++;
                }
                int v = Integer.parseInt(str.substring(pre, i));
                res += (flag % 2 == 1) ? v * (-1) : v;
                i--;
            } else if (chs[i] == '-') {
                flag++;
            }
        }
        System.out.println(res);
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
