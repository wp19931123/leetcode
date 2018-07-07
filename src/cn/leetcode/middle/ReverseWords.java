package cn.leetcode.middle;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例:
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 说明:
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶: 请选用C语言的用户尝试使用 O(1) 时间复杂度的原地解法。
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.print(new ReverseWords().reverseWords("   a   b  c d   e  "));
    }

    public String reverseWords(String s) {
        if(s == null || s.trim().length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            char[] ch = arr[i].toCharArray();
            arr[i] = reverse(ch); //每个单词反转一遍
        }
       //整个反转
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            if(str.length() == 0) {  //去除空格
                continue;
            }
            sb.append(str);
            sb.append(" ");
        }
        return reverse(sb.toString().toCharArray()).trim();
    }

    private String reverse(char[] ch) {
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void swap(char[] arr,int i,int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
