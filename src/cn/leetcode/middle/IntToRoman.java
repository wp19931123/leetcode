package cn.leetcode.middle;

/**
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntToRoman {

    public String intToRoman(int num) {
        String res = "";
        if(num < 0) {
            return res;
        }
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roms = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i = 0; i < 13 && num > 0; i++){
            if(num < numbers[i]) {
                continue;
            }
            while(num >= numbers[i]) {
                num -= numbers[i];
                res += roms[i];
            }
        }
        return res;
    }
}
