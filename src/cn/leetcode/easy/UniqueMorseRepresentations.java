package cn.leetcode.easy;


import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new UniqueMorseRepresentations().uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] strs = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i = 0;i < words.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < words[i].length();j++) {
                sb.append(strs[words[i].charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
