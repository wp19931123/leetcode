package exam.xiecheng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class XC2_hy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Record[] arr = new Record[n];
        int A = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = new Record(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr, new AscendingComparator());
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (A >= arr[i].intime && A <= arr[i].outtime) {
                flag = true;
                System.out.println(arr[i].orderno);
            }
        }
        if (!flag) {
            System.out.println("null");
        }
    }

    public static class AscendingComparator implements Comparator<Record> {
        @Override
        public int compare(Record o1, Record o2) {
            return o1.orderno - o2.orderno;
        }
    }

    static class Record {
        int orderno;
        int intime;
        int outtime;

        public Record(int orderno, int intime, int outtime) {
            this.orderno = orderno;
            this.intime = intime;
            this.outtime = outtime;
        }
    }
}