package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回所有可能得到的字符串集合。S 仅由数字和字母组成。
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("rmr"));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        String str = S.toLowerCase();
        res.add(str);
        for(int i = 0;i < str.length();i++) {
            int size = res.size();
            if(isZimu(str.charAt(i))) {
                for(int j = 0; j < size;j++) {
                    res.add(smlToBig(res.get(j),i));
                }
            }
        }
        return res;
    }

    public boolean isZimu(char c) {
        return c >= 'a' && c <= 'z';
    }
    //把某个位置的字符小写转大写
    public String smlToBig(String str,int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++) {
            if(i == index) {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
