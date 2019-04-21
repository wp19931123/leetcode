package exam.test2020.tencent;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        if(len < 1 || str == null || str == "") {
            return;
        }
        //消除01
        Stack<Character> s = new Stack<>();
        for(int i = 0;i < str.length();i++) {
            if(s.isEmpty()) {
                s.push(str.charAt(i));
                continue;
            }
            if(s.peek() == str.charAt(i)) {
                s.push(str.charAt(i));
            }else{
                s.pop();
            }
        }

        System.out.println(s.size());
    }
}
