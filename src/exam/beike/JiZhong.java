package exam.beike;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JiZhong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            indexMap.put(temp1, i);
            treeMap.put(temp1, temp2);
        }
        System.out.println(treeMap);
        Integer[] integers = new Integer[n];
        Object[] objects1 = treeMap.keySet().toArray();
        for (int i = 0; i < n; i++) {
            integers[i] = (Integer) objects1[i];
        }
        for (int i = 0; i < n; i++) {
            int temp = integers[i];
            int max = temp + treeMap.get(temp);
            System.out.println(max);
            int count = 1;
            while ((i + count < n) && (max > integers[i + count])) {
                temp = integers[i + count];
                if (temp + treeMap.get(temp) > max) {
                    max = temp + treeMap.get(temp);
                }

                count++;
            }
            result[indexMap.get(integers[i])] = count;
        }
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(result[i] + " ");
            } else {
                System.out.print(result[i]);
            }
        }
    }

}
