package cn.leetcode.middle;

import java.util.*;

/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class LadderLength {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.print(new LadderLength().ladderLength(start,end,wordList));
    }
    /**
     *解题思路：把每个string看作节点，如果string之间距离为1说明有连线，相当于找到最短的连线长度。这里的解法是宽搜，
     * 用队列存节点，用一个map存访问过的节点，从队列取一个元素，把这个元素的所有距离为1的string找出来加入到队列里
     * （前提是这个str在dict中并且没被访问过且不同于原始的这个元素）。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.add(endWord);
        visited.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int sz = 0; sz < size; sz++) {
                String str = queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        if(chars[i]==j) {
                            continue;
                        }
                        chars[i] = j;
                        String tmp = new String(chars);
                        if (tmp.equals(endWord)) {
                            return res + 1;
                        }
                        if (!tmp.equals(str) && !visited.contains(tmp) && wordList.contains(tmp)) {
                            visited.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
            }
            res++;

        }
        return 0;
    }
}
