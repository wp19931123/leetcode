package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * 输入: "2-1-1"   输出: [0, 2]
 * 解释: ((2-1)-1) = 0 || (2-(1-1)) = 2
 */
public class DiffWaysToCompute {

    public static void main(String[] args) {
        System.out.println(new DiffWaysToCompute().diffWaysToCompute("2-1-1"));
    }

    //1.按照运算符做分割，然后用分治算法解。
    //2.边界条件为：如果剩下的的字符串中没有运算符，即剩下的字符串中有且仅有数字。
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
           return res;
        }
        for(int i = 0;i < input.length();i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> res1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i+1));
                for(int r1 : res1) {
                    for(int r2 : res2) {
                        if(c == '+') {
                            res.add(r1+r2);
                        }else if(c == '-') {
                            res.add(r1 - r2);
                        }else{
                            res.add(r1 * r2);
                        }
                    }
                }
            }

        }
        if(res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
