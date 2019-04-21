package exam.test2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int len = Integer.parseInt(sc.nextLine());
            List<String[]> list = new ArrayList<>();
            int maxLen = 0;

            while(sc.hasNextLine()) {
                String[] s = sc.nextLine().split(",");
                if(s.length > maxLen) {
                    maxLen = s.length;
                }
                list.add(s);
            }

            StringBuffer sb = new StringBuffer();
            int index = 0;
            while(true) {
                for (int j = 0; j < list.size(); j++) {
                    String[] strings = list.get(j);
                    for(int i = index; i < strings.length && i < len+index; i++) {
                        sb.append(strings[i] + ",");
                    }
                }

                index += len;
                if(index >= maxLen) {
                    break;
                }

            }
            String result = sb.toString().substring(0,sb.length() - 1);
            System.out.println(result);
        }

    }
}
