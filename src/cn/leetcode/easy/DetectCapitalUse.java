package cn.leetcode.easy;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 1,全部字母都是大写，比如"USA"。
 * 2,单词中所有字母都不是大写，比如"leetcode"。
 * 3,如果单词不只含有一个字母，只有首字母大写， 比如 "Google"
 */
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        char c1 = word.charAt(0);
        String tmp = word.substring(1);
        if(betweenChars(c1,'A','Z') && tmp.length() != 0 && tmp.chars().allMatch(c -> betweenChars((char)c,'a','z'))) {
            return true;
        }
        return word.chars().allMatch(c -> betweenChars((char)c,'A','Z')) || word.chars().allMatch(c -> betweenChars((char)c,'a','z'));
    }

    private boolean betweenChars(char c, char startChar, char endChar) {
        return c >= startChar && c <= endChar;
    }
}
