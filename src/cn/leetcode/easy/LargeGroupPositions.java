package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 */
public class LargeGroupPositions {
    public static void main(String[] args) {
        System.out.println(new LargeGroupPositions().largeGroupPositions("aaa"));
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if(S == null || S.length() < 3) {
            return res;
        }
        int start = 0;
        int end = 0;
        for(int i = 1;i < S.length();i++) {
            if(S.charAt(i) != S.charAt(i-1)) {
                if(end - start >= 2) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(start);
                    tmp.add(end);
                    res.add(tmp);
                }
                start = i;
                end++;
            }else{
                end++;
                if(i == S.length()-1) {
                    if(end - start >= 2) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(start);
                        tmp.add(end);
                        res.add(tmp);
                    }
                }

            }
        }
        return res;
    }
}
