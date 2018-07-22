package cn.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {

    boolean isword;
    Map<Character, Trie> next;

    /**
     * Initialize your data structure here.
     * 时间：插入和查询都是O(K) 空间： O(NK) N是字典里词的个数，K是词的长度
     * 实现树节点时使用了哈希表来映射字母和子节点的关系
     */
    public Trie() {
        isword = false;
        next = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     * 对于插入操作，我们遍历字符串同时，根据上一个节点的哈希表来找到下一个节点，直到哈希表中没有相应的字母，
     * 我们就新建一个节点。然后从这个新建节点开始，用同样的方法把剩余的字母添加完。记住最后一个字母要添加叶子节点的标记，表明这个词到此已经完整了。
     */
    public void insert(String word) {
        Trie tp = this;
        for (int i = 0; i < word.length(); i++) {
            if (tp.next.containsKey(word.charAt(i))) {
                tp = tp.next.get(word.charAt(i));
            } else {
                Trie t = new Trie();
                tp.next.put(word.charAt(i), t);
                tp = t;
            }
        }
        tp.isword = true;
    }

    /**
     * Returns if the word is in the trie.
     * 对于搜索操作，我们也是遍历字符串，然后根据每个节点的哈希表找到路径，
     * 最后返回该字符串最后一个字母所在节点。如果中途有找不到路径的情况就直接返回null，
     * 如果找到了最后的节点，如果它也是叶子结点的话，就说明找到了。
     */
    public boolean search(String word) {
        Trie tp = this;
        for (int i = 0; i < word.length(); i++) {
            if (tp.next.containsKey(word.charAt(i))) {
                tp = tp.next.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return tp.isword;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * 使用和search()一样的方法，只是我们返回的节点不用判断是否是叶子节点。只要找到就行
     */
    public boolean startsWith(String prefix) {
        Trie tp = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (tp.next.containsKey(prefix.charAt(i))) {
                tp = tp.next.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    // Initialize your data structure here.
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf = false;
    String str;
    public TrieNode(){}
    public TrieNode(char c) {
        this.str = String.valueOf(c);
    }
}
