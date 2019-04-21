package exam.netease.net2;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str += str;
        int res = 1;
        int tmp = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                tmp = 1;
            } else {
                tmp++;
                res = Math.max(res, tmp);
            }
        }
        int ans = Math.min(res, str.length() / 2);
        System.out.println(ans);
    }
}
