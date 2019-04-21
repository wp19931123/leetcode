package exam.test2020.tencent;

import java.util.Scanner;

public class Money {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[1100];
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++){
            a[i] = scanner.nextInt();
        }
        //sort
        sort(a, 1, n);
        if(a[1] != 1){
            System.out.println("-1");
            return;
        }

        int sum = 0, ans = 0;
        while (true){
            if(sum >= m){
                System.out.println(ans);
                return;
            }
            for (int i = n; i >= 1; i--){
                if(a[i] <= sum + 1){
                    sum += a[i];
                    ans++;
                    break;
                }
            }
        }
    }

    public static int partition(int[] array, int lo, int hi) {
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }
}
