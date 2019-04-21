package exam.jingchi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> res = new LinkedHashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, 1);
        }
        for (int i = 0; i < A; i++) {
            String str = sc.next();
            if (str.equals("T")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(b, map.get(b) + map.get(a));
                map.put(a, 0);
            } else if (str.equals("Q")) {
                int a = sc.nextInt();
                res.put(a, map.get(a));
            }
        }
        for (Map.Entry<Integer, Integer> m : res.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        sc.close();
    }
}
