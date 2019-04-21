package exam.shence;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t1 = sc.nextLine();
        String add = sc.nextLine();
        String[] s1 = t1.split(":");
        String[] s2 = add.split(":");
        int[] res = new int[3];
        for(int i = 2;i >= 0;i--) {
            int tmp = Integer.parseInt(s1[i]) + Integer.parseInt(s2[i]);
            int flag = 0;
            if(tmp >= 60) {
                tmp -= 60;
                flag = 1;
            }
            res[i-1] += flag;
            res[i] = tmp;

        }
        StringBuilder sb = new StringBuilder();
    }
}
