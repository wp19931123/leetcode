package cn.leetcode.easy;

/**
 * 至少多少行能放下S，以及最后一行使用的宽度是多少个单位？
 * S 只包含小写字母。
 * widths 是长度为 26的数组。
 */
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String S) {
        int lineNum = 0;
        int curLen = 0;
        for(int i = 0;i < S.length();i++) {
            if(curLen + widths[S.charAt(i) - 'a'] > 100) {
                lineNum++;
                curLen = widths[S.charAt(i) - 'a'];
            }else{
                curLen += widths[S.charAt(i) - 'a'];
            }
        }
        if(curLen != 0) {
            lineNum++;
        }
        return new int[]{lineNum,curLen};
    }
}
