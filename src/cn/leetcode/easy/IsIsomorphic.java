package cn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 两个字符不能映射到同一个字符上
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("ab","aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                }else{
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }else{
                    map.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        return true;
    }
}
