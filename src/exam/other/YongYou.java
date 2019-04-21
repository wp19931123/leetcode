package exam.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//输出数组的最长连续数字，不包含重复元素
public class YongYou {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxSucc = 1;
        int tmp = 1;
        int[] res = new int[2];
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            list.add(Integer.valueOf(strs[i]));
        }
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            System.out.println("[" + list.get(0) + "," + 1 + "]");
            return;
        }
        int pre = list.get(0);
        int cur = 0;
        for (int i = 1; i < list.size(); i++) {
            cur = list.get(i);
            if (cur - 1 == pre) {
                tmp++;
            } else {
                if (tmp > maxSucc) {
                    maxSucc = tmp;
                    res[0] = pre - tmp + 1;
                    res[1] = maxSucc;
                }
                tmp = 1;
            }
            pre = cur;
        }
        if (tmp > maxSucc) {
            maxSucc = tmp;
            res[0] = cur - tmp + 1;
            res[1] = maxSucc;
        }
        System.out.println("[" + res[0] + ", " + res[1] + "]");
        sc.close();
    }
}
