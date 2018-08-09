package cn.leetcode.middle;

import java.util.Stack;

/**
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的
 */
public class IsValidSerialization {

    public static void main(String[] args) {
        System.out.print(new IsValidSerialization().isValidSerialization("1,#,#,#,#"));
    }

    /**
     * 叶节点没有子节点。此时可以将该叶节点消除，即用一个"#"代替，
     * 一层层向上归并消除直至根节点，最终只剩一个"#"。可以用栈来实现该过程
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String s : strs) {
            if(s.equals("#")) {
                while(stack.size() > 1 && stack.peek().equals("#")) {
                    stack.pop();
                    stack.pop();
                }
            }
            stack.push(s);
        }
        if(!stack.isEmpty() && stack.pop().equals("#") && stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
