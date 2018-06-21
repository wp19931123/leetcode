package cn.leetcode.easy;

/**
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。
 * 最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 */
public class FindLUSlength {

    public int findLUSlength(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if(lenA != lenB) {
            return lenA > lenB ? lenA : lenB;
        }else{
            if(a.equals(b)) {
                return -1;
            }else{
                return lenA;
            }
        }
    }
}
