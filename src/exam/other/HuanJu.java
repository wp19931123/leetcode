package exam.other;

import java.util.Arrays;
import java.util.Scanner;

public class HuanJu {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++) {
                arr[i] = sc.nextInt();
            }
            //
            int[] help = new int[N];
            for(int i = 0;i < N;i++) {
                help[i] = arr[i];
            }
            int res = 0;
            Arrays.sort(help);
            //求最小公倍数
            int s=1;
            for(int i=2;i<=help[N-1];i++){

                boolean b=false;	//设置标记

                for(int j=0;j<N;j++){
                    if(help[j]%i==0){
                        help[j]=help[j]/i;
                        b=true;
                    }
                }

                if(b){
                    s*=i;
                    i--;
                }
            }

            for(int i=0;i<N;i++){
                s*=arr[i];	//在将s与最后得到的不能再继续辗转相除的数累乘
            }

            for(int i = 1;i < s;i++) {
                int sum = 0;
                for(int j = 0;j < arr.length;j++) {
                    sum += (i%arr[j]);
                }
                if(sum > res) {
                    res = sum;
                }
            }
            System.out.println(res);
        }

}
