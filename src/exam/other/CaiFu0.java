package exam.other;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class CaiFu0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() >= 2) {
            Integer remove = queue.remove();
            System.out.print(remove + " ");
            Integer remove1 = queue.remove();
            queue.add(remove1);
        }
        System.out.println(queue.remove());
    }
}
