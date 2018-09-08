package exam.beike;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XX {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int num = s.nextInt();
            Map<Integer, Integer> treeMap = new HashMap<>();
            Map<Integer, Integer> map = new HashMap<>();
            int[] index = new int[num];
            int[] pr = new int[num];
            int x, h;
            if (num == 0) {
                return;
            }
            for (int i = 0; i < num; i++) {
                String s1 = s.nextLine();
                String[] strings = s1.split(" ");
                x = Integer.valueOf(strings[0]);
                index[i] = x;
                pr[i] = x;
                h = Integer.valueOf(strings[1]);
                treeMap.put(x, h);
                map.put(x, 1);
            }
            Arrays.sort(index);
            for (int i = num - 2; i >= 0; i--) {
                if (treeMap.get(index[i]) + index[i] <= index[i + 1]) {
                    map.put(index[i], 1);
                } else {
                    int j = i + 1;
                    while (j < num) {
                        if (treeMap.get(index[i]) + index[i] > index[j]) {
                            map.put(index[i], Math.max(map.get(index[j]) + 1, Math.max(map.get(index[i]), j - i + 1)));
                        } else {
                            break;
                        }
                        j++;
                    }
                }
            }
            for (int k : pr) {
                System.out.print(map.get(k) + " ");
            }
        }

    }
}
