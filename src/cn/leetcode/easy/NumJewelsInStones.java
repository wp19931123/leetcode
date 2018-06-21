package cn.leetcode.easy;

public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int domond = 0;
        for(int i = 0;i < J.length();i++) {
            for(int j = 0;j < S.length();j++) {
                if(S.charAt(j) == J.charAt(i)) {
                    domond++;
                }
            }
        }
        return domond;
    }

}
