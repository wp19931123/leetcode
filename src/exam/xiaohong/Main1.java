package exam.xiaohong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() < 1)
            System.out.println();
        else {
            char[] chs = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            char tmp = chs[0];
            int count = 0;
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] == tmp) {
                    count++;
                } else {
                    if (count == 0) {
                        sb.append(tmp);
                        count = 0;
                    } else {
                        sb.append(count);
                        sb.append(tmp);
                        count = 0;
                    }
                }
                tmp = chs[i];
            }
            if (count == 0)
                sb.append(tmp);
            else {
                sb.append(count);
                sb.append(tmp);
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}