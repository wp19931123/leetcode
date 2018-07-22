package cn.leetcode.middle;

/**
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * 示例:
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("apple");
        wd.addWord("qiniu");
        System.out.print(wd.search("app.."));
        System.out.print(wd.search("app."));
        System.out.print(wd.search("..niu"));
    }

    TrieNode t;

    class TrieNode {  //字典树
        TrieNode[] children;
        boolean isWord;  //表明该节点存在对应单词

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }


    /**
     * Initialize your data structure here.
     * 超出时间限制
     */
    public WordDictionary() {
        t = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = t;
        for (char c : word.toCharArray()) {
            int j = c - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }


    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     * 遍历word和字典树，若遇到字符’.’，则回溯字典树当前节点的所有分支
     */
    public boolean search(String word) {
        return find(word, t, 0);
    }

    private boolean find(String word, TrieNode node, int index) {
        //若到达word末尾，判断字典树当前节点是否有对应字符串
        if (index == word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode tmp : node.children) {
                if (tmp != null && find(word, tmp, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            TrieNode tmp = node.children[j];
            return tmp != null && find(word, tmp, index + 1);
        }
    }
}