package cn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 */
public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph,banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        //如何去除标点符号
        String tmp1 = paragraph.toLowerCase();
        String str = "";
        for(int i = 0;i < tmp1.length();i++) {
            if(isa2zSpace(tmp1.charAt(i))) {
                str += tmp1.charAt(i);
            }
        }
        String[] para = str.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < para.length;i++) {
            if(!onArray(banned,para[i])) {
                if(map.containsKey(para[i])) {
                    map.put(para[i],map.get(para[i]) + 1);
                }else{
                    map.put(para[i],1);
                }
            }
        }
        int max = 0;
        String res = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public boolean onArray(String[] strs,String s) {
        for(int i = 0;i < strs.length;i++) {
            if(strs[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
    public boolean isa2zSpace(char c) {
        return ((c >= 'a' && c <= 'z') || c == ' ');
    }
}
