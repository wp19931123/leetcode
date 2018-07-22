package cn.leetcode.middle;

import java.util.*;

/**
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的10个字母长的序列（子串）。
 */
public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.print(new FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    //哈希表：时间 O(N) 空间 O(N)
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length()-9;i++) {
            String sub = s.substring(i,i+10);
            if(map.containsKey(sub)) {
                if(!res.contains(sub)) {
                    res.add(sub);
                }
            }else{
                map.put(sub,1);
            }
        }

        return res;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int index = 10; index <= s.length(); index++){
            String substr = s.substring(index - 10, index);
            int code = encode(substr);
            if(map.containsKey(code)){
                if(map.get(code) == 1){
                    res.add(substr);
                }
                map.put(code, 2);
            } else {
                map.put(code, 1);
            }
        }
        return res;
    }

    private int encode(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // 每两位表示一个字符
            code <<= 2;
            switch(c){
                case 'A': code += 0; break;
                case 'C': code += 1; break;
                case 'T': code += 2; break;
                case 'G': code += 3; break;
            }
        }
        return code;
    }
}
