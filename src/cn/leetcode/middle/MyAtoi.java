package cn.leetcode.middle;

/**
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，
 * 并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("009"));
    }

    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        String s = str.trim();
        String resStr = null;
        if(s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        if(c == '-' || (c >= '0' && c <= '9')) {
            int end = 1;
            while(end < s.length()) {
                if(isNum(s.charAt(end))) {
                    end++;
                }else {
                    resStr = s.substring(0,end);
                }
            }
        }else{
            return 0;
        }
        long resL = Long.valueOf(0);

        return 0;
    }

    public boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
