package exam.other;

import java.util.Scanner;

public class IQiYi1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() != 6) {
            return;
        }
        int preSum = 0;
        int tailSum = 0;
        for(int i = 0;i < 3;i++) {
            preSum += s.charAt(i) - '0';
        }
        for(int i = 3;i < 6;i++) {
            tailSum += s.charAt(i) - '0';
        }
//        if()
    }
}
