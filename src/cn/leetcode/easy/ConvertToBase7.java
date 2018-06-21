package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */
public class ConvertToBase7 {

    public static void main(String[] args) {
        System.out.println(new ConvertToBase7().convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        boolean flag = num > 0 ? true : false;
        if(flag == false) {
            num = -num;
        }
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            list.add(num % 7);
            num /= 7;
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        if(flag == false) {
            sb.append("-");
        }
        for(int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
