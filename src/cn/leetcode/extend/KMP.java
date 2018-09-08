package cn.leetcode.extend;

/**
 * 在字符串s中找到一个等于t的子串
 */
public class KMP {

    public static int getIndexOf(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }

        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] ch) {
        if (ch.length == 1) {
            return new int[]{-1};
        }
        int[] res = new int[ch.length];
        res[0] = -1;
        res[1] = 0;
        int i = 2;
        int cn = 0; //跳到的位置
        while (i < res.length) {
            if (ch[i - 1] == ch[cn]) {
                res[i++] = ++cn;
            } else if (cn > 0) {
                cn = res[cn];
            } else {
                res[i++] = 0;
            }
        }

        return res;
    }
}
