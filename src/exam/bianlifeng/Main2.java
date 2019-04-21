package exam.bianlifeng;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    static ArrayList<ArrayList<String>> lists=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        String[] a = new String[chs.length];
        for(int i = 0; i < chs.length;i++) {
            a[i] = chs[i] + "";
        }
        ArrayList<String> list = new ArrayList<>();
        recursive(a,0,list);
        for(ArrayList<String> t : lists) {
            StringBuilder sb = new StringBuilder();
            for(String s : t) {
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }


        private static void recursive(String[] a, int index, ArrayList<String> list) {
            if (index==a.length) {
                lists.add(new ArrayList<>(list));
                return;
            }

                list.add(a[index]);
                recursive(a, index + 1, list);
                list.remove(a[index]);
                list.add(a[index].toUpperCase());
                recursive(a, index + 1, list);
                list.remove(a[index].toUpperCase());
        }

        private static boolean isString(char c) {
            if((c > 'a' && c< 'z') || (c > 'A' && c < 'Z')) {
                return true;
            }
            return false;
        }


    }
