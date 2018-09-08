package exam.meituan;

import java.util.*;

public class MT02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(genaratorArr(arr, k, t));
        sc.close();
    }

    public static int genaratorArr(int[] arr, int k, int count) {
        int len = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + k <= len) {
                List<Integer> list = new ArrayList<>();
                sum++;
                for (int j = i; j < i + k; j++) {
                    list.add(arr[j]);
                }
                res.add(list);
            }
        }

        for (List<Integer> list : res) {
            if (!getCountNum(list, count)) {
                sum--;
            }
        }
        return sum;
    }

    public static boolean getCountNum(List<Integer> list, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) >= count) {
                return true;
            }
        }
        return false;
    }


}
