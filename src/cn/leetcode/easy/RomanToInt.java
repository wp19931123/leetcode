package cn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("IV"));
    }

    /**
     * 小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数
     * 小的数字在大的数字的左边、所表示的数等于这些数字相减得到的数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int preValue = 0;
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if(cur < preValue) {
                res -= cur;
            }else{
                res += cur;
            }
            preValue = cur;
        }
        return res;
    }
}
