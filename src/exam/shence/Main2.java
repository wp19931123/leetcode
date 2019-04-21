package exam.shence;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        if(n <= 0) {
            return;
        }
        String[] strs = new String[n];
        for(int i = 0;i < n;i++) {
            strs[i] = sc.nextLine();
        }
        for(int i = 0;i < n;i++) {
            if(isNumeric(strs[i].toCharArray())) {
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }

        }
        sc.close();
    }

    public static boolean isNumeric(char[] str) {
        String regex = "[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?";
        String s = String.valueOf(str);
        return s.matches(regex);
    }
}
