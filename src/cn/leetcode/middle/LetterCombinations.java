package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> res = new LetterCombinations().letterCombinations("23");
        for(String s : res) {
            System.out.print(s + " ");
        }
    }

    //定义每个数字对应的字符
    static String[] a = new String[] {"","","abc","def",
            "ghi","jkl","mno","pqrs","tuv","wxyz"};
    static StringBuffer sb = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return null;
        }
        List<String> answer = new ArrayList<String>();

        //开始回溯
        zuhe(digits , 0 , answer);
        return answer;
    }

    private static void zuhe(String digits , int n, List<String> answer) {
        if (n == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < a[digits.charAt(n)-'0'].length(); i++) {
            sb.append(a[digits.charAt(n)-'0'].charAt(i));
            zuhe(digits, n + 1, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
