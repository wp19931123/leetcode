package exam.mi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TT {

    public static void main(String[] args) {
        int flag = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        String tmp;
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (!(tmp = in.nextLine()).equals("END")) {
            list.add(tmp);
        }
        for (String string : list) {
            String[] arr = string.split("#");
            int value = Integer.valueOf(arr[1], Integer.valueOf(arr[0]));
            map2.put(value, string);
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for (String string : list) {
            String[] arr = string.split("#");
            int value = Integer.valueOf(arr[1], Integer.valueOf(arr[0]));
            if (map.get(value).equals(1)) {
                System.out.println(map2.get(value));
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("None");
        }

    }
}
