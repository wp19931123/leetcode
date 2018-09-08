package exam.beike;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuoMiNuo {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 4;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(16, 4);
        map.put(20, 4);
        map.put(10, 9);
        map.put(18, 1);
        int[] arr = new int[n];
        arr[0] = 16;
        arr[1] = 20;
        arr[2] = 10;
        arr[3] = 18;
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            map.put(arr[i], sc.nextInt() - 1);
//        }
        if (arr == null || arr.length == 0) {
            return;
        }
        Arrays.sort(arr);  //arr[i]表示下标
        if (arr.length == 1) {
            System.out.println(1);
            return;
        }
        int[] res = new int[n]; //保存结果
        int[] yuan = new int[n]; //保存压倒到的最远位置
        res[n - 1] = 1;
        yuan[n - 1] = n;
//        res[n-2] = arr[n-2] + map.get(arr[n-2]) >= arr[n-1] ? 2 : 1;
        for (int i = n - 2; i >= 0; i--) {
            int dis = arr[i] + map.get(arr[i]);
            for (int j = i + 1; j < n; j++) {
                if (dis >= arr[j]) {
                    if (dis >= yuan[j]) {
                        res[i]++;
                        yuan[i] = dis;
                    } else {
                        res[i] = 1 + res[j];
                        j = yuan[j];
                        yuan[i] = arr[j] + map.get(arr[j]);
                    }
                }
            }

        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }


}
