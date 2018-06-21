package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
 */
public class FindWords {

    public static void main(String[] args) {
        String[] strs = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = new FindWords().findWords(strs);
        for(String s : res) {
            System.out.print(s+ " ");
        }
    }

    public String[] findWords(String[] words) {
        char[] ch1 = {'q','w','e','r','t','y','u','i','o','p'};
        char[] ch2 = {'a','s','d','f','g','h','j','k','l'};
        char[] ch3 = {'z','x','c','v','b','n','m'};
        List<String> list = new ArrayList<>();
        for (int i = 0;i < words.length;i++) {
            boolean flag = true;
            if(chContain(words[i].toLowerCase().charAt(0),ch1)) {
                for (int j = 1;j < words[i].length();j++) {
                    if(!chContain(words[i].toLowerCase().charAt(j),ch1)) {
                        flag = false;
                       break;
                    }
                }
            }else if(chContain(words[i].toLowerCase().charAt(0),ch2)){
                for (int j = 1;j < words[i].length();j++) {
                    if(!chContain(words[i].toLowerCase().charAt(j),ch2)) {
                        flag = false;
                        break;
                    }
                }
            }else{
                for (int j = 1;j < words[i].length();j++) {
                    if(!chContain(words[i].toLowerCase().charAt(j),ch3)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag == true) {
                list.add(words[i]);
            }
        }
        int s = list.size();
        String[] res = new String[s];
        for(int i = 0;i < s;i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public boolean chContain(char c,char[] ch) {
        for(int i = 0;i < ch.length;i++) {
            if(ch[i] == c) {
                return true;
            }
        }
        return false;
    }
}
