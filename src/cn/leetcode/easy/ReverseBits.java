package cn.leetcode.easy;


/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.print(new ReverseBits().reverseBits(43261596)); //964176192
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        //严格32位
        char[] ch = new char[32];
        for(int i = 32-s.length();i < 32;i++) {
            ch[i] = s.charAt(i-32+s.length());
        }
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            swap(ch, l++, r--);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            sb.append(c);
        }  //00000010100101000001111010011100
        String binStr = sb.toString();
        int a = Integer.valueOf(binStr,2);
        return a;
    }

        public static void swap(char[] arr,int i,int j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

}
