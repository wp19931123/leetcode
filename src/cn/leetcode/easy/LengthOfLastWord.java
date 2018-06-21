package cn.leetcode.easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if(s == "") {
            return 0;
        }
        int len = s.length();
        int i = s.lastIndexOf(" ");
        if(i == -1) {
            return len;
        }

        return len-i-1;
    }
}
