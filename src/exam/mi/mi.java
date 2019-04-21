package exam.mi;

import java.util.*;

public class mi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();  //保存str,10进制
        Map<Integer, Integer> map2 = new HashMap<>(); //保存十进制，个数

        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.equals("END")) {
                break;
            }
            Integer shi = StringToTen(str);
            map.put(str, shi);
            if (!map2.containsKey(shi)) {
                map2.put(shi, 1);
            } else {
                map2.put(shi, map2.get(shi) + 1);
            }
        }
        //遍历map2
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if(entry.getValue() == 1) {
                set.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(set.contains(entry.getValue())) {
                res.add(entry.getKey());
            }
        }
        sc.close();
    }

    private static Integer StringToTen(String str) {
        String[] ss = str.split("#");
        int jin = Integer.valueOf(ss[0]);
        int res = 0;
        for (int i = 0; i < ss[1].length(); i++) {
            res += Integer.valueOf(ss[1].charAt(i)) * Math.pow(jin, ss[1].length() - i - 1);
        }
        return res;
    }


}
