package exam.nubiya;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(",");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]); //第m次落地
//        int n = sc.nextInt();
//        int m = sc.nextInt();  //第m次落地
        double res = n;  //求共经过了多少米
        double tan = n/2;
        if (m < 1) {
            return;
        }
        if(m == 1) {
            System.out.println(res);
            return;
        }
        for (int i = 1; i < m; i++) {
            res += 2 * tan;
            tan /= 2;
        }
        System.out.println(res);
        sc.close();
    }

}
