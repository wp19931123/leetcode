package exam.test2020.tencent;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        if(len < 1 || str == null || str == "") {
            return;
        }
        //消除01
        int left = 0;
        int right = 1;
        int pre = 0;
        int aba = 0;
        while(right < len) {
            if(str.charAt(right) != str.charAt(pre)) {
                aba += 2;
                pre--;
                right++;
            }else{
                right++;
                pre++;
            }
            if(pre < left) {
                pre = right;
                left = pre;
                right++;
            }
        }

        System.out.println(len - aba);
    }
}
