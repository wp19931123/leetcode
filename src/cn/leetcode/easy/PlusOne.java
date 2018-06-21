package cn.leetcode.easy;

public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(new PlusOne().plusOne2(arr));
    }
    //转换成int long来处理  均会越界
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : digits) {
            sb.append(i);
        }
        long num = Long.valueOf(sb.toString());
        if(num == 0) {
            return new int[]{1};
        }
        Long i = num+1;
        String str = i.toString();
        int[] res = new int[str.length()];
        for(int j = 0;j < str.length();j++) {
            res[j] = str.charAt(j)-48;
        }
        return res;
    }
    //从后往前判断当前是不是9
    public int[] plusOne2(int[] digits) {
        if(digits == null || digits.length == 0) {
            return null;
        }
        int len = digits.length-1;
        while(len >= 0 && digits[len] == 9)         {
            len--;
        }
        if(len == -1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        digits[len]++;
        for(int i = len+1;i < digits.length;i++) {
            digits[i] = 0;
        }
        return digits;
    }

}
