package exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintSu {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        System.out.println("一共有" + list.size() + "个素数");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static boolean isPrime(int i) {
        boolean flag = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                flag = false;
            }
        }
        return flag;
    }
}
