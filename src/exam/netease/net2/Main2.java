package exam.netease.net2;

import java.util.Scanner;

public class Main2 {

    //两边都要相邻，
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count;i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(getMinCount(n,k));
            System.out.println(getMaxCount(n,k));
        }
    }

    private static int getMaxCount(int n, int k) {


        return 0;
    }

    private static int getMinCount(int n, int k) {
        if(n <= 2 || k < 2 || k >= n) {
            return 0;
        }



        return 0;
    }
}
