package cn.leetcode.middle;

import java.util.*;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 */
public class FractionToDecimal {

    public static void main(String[] args) {
        System.out.print(new FractionToDecimal().fractionToDecimal2(1, 17));
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        HashMap<Long, Integer> maps = new HashMap<>();//store divid number
        List<Long> number = new ArrayList<>();
        int index = 0;
        int beginIndex = -1;

        StringBuilder builder = new StringBuilder();
        if (denominator == 0)
            return "";
        long num = numerator;
        long denum = denominator;
        if ((num < 0 && denum > 0) || (num > 0 && denum < 0))
            builder.append('-');

        num = Math.abs(num);
        denum = Math.abs(denum);

        long val = num / denum;
        builder.append(String.valueOf(val));
        num = (num % denum) * 10;

        while (num != 0) {
            if (maps.containsKey(num)) {//开始重复
                beginIndex = maps.get(num);
                break;
            } else {
                maps.put(num, index++);
                val = num / denum;
                num = (num % denum) * 10;
                number.add(val);
            }
        }
        for (int i = 0; i < index; i++) {
            if (i == 0)
                builder.append('.');
            if (i == beginIndex) {
                builder.append('(');
            }
            builder.append(number.get(i));
        }
        if (beginIndex != -1)
            builder.append(')');

        return builder.toString();
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        String res = "";
        if (numerator < 0 ^ denominator < 0) {
            res += "-";
        }
        long numer = (long) numerator < 0 ? ((long) numerator * (-1)) : (long) numerator;
        long denom = (long) denominator < 0 ? (long) denominator * (-1) : (long) denominator;
        long inte = numer / denom;
        res += Long.toString(inte);
        long rmd = numer % denom;   //余数
        if (rmd == 0) {
            return res;
        }
        rmd *= 10;   //被除数
        res += ".";
        Set<Long> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (rmd / denom == 0) {
            set.add(0l);
            count++;
            res += "0";
            rmd *= 10;
        }
        while (rmd != 0) {
            long quo = rmd / denom;  //余数
            String q = Long.toString(quo);
            if (set.contains(quo)) {
                int len = res.length();
                int pointIndex = res.indexOf(".");
                int index = -1;
                for (int i = pointIndex + 1; i < len; i++) {
                    String tmp = res.substring(i, i + 1);
                    if (tmp.equals(q)) {
                        index = i;
                        break;
                    }
                }
                for (int i = 0; i < index; i++) {
                    sb.append(res.charAt(i));
                }
                sb.append("(");
                for (int i = index; i < len; i++) {
                    sb.append(res.charAt(i));
                }
                sb.append(")");
                return sb.toString();
            }
            set.add(quo);
            res += q;
            rmd = (rmd % denom) * 10;
        }
        return res;
    }
}
