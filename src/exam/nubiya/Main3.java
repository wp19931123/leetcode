package exam.nubiya;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.next();
        //查找
        int res = getCount(str, target);
        System.out.println(res);
        String output = new Main3().reverseWords(str);
        System.out.println(output);

    }

    private static int getCount(String s, String target) {
        int res = 0;
        if (s == null || s.trim().length() == 0) {
            return res;
        }
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains(target)) {
                res++;
            }
        }
        return res;
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            char[] ch = arr[i].toCharArray();
            arr[i] = reverse(ch); //每个单词反转一遍
        }
        //整个反转
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            if (str.length() == 0) {  //去除空格
                continue;
            }
            sb.append(str);
            sb.append(" ");
        }
        return reverse(sb.toString().toCharArray()).trim();
    }

    private String reverse(char[] ch) {
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
