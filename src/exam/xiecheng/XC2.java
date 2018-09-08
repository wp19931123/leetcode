package exam.xiecheng;

import java.util.Scanner;
import java.util.TreeSet;

public class XC2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            if (a >= startTime && a <= endTime) {
                set.add(id);
            }
        }
        if (set.size() == 0) {
            System.out.println("null");
        } else {
            set.stream().forEach(System.out::println);
        }
        scanner.close();
    }
}
