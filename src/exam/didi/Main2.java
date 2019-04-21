package exam.didi;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = {1,2,3,4};
        int[] arr = new int[4];
        for(int i = 0;i < 4;i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        boolean boo = IsPopOrder(d,arr);
        if(boo) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        Stack<Integer> st = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len && index2 < len) {
            if (st.isEmpty()) {
                st.push(pushA[index1++]);
            }
            if (st.peek() == popA[index2]) {
                st.pop();
                index2++;
            } else {
                if (index1 < len) {
                    st.push(pushA[index1++]);
                }
            }
        }
        if (index1 == len) {
            while (!st.isEmpty()) {
                if (st.pop() != popA[index2++]) {
                    return false;
                }
            }
        }
        if (index2 == len) {
            return true;
        } else {
            return false;
        }

    }
}
