package exam.huawei;

import java.util.Scanner;

public class HUAWEI01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] <= 90 && chs[i] >= 65) {
                    chs[i] = (char) (chs[i] + 32);
                } else if (chs[i] >= 97 && chs[i] <= 122) {
                    chs[i] = (char) (chs[i] - 32);
                }
                System.out.print(chs[i]);
            }
        }
    }
}
