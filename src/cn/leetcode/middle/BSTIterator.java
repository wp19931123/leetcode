package cn.leetcode.middle;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 */
public class BSTIterator {

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return s.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if(!hasNext()) {
            throw new RuntimeException("empty");
        }
        TreeNode p = s.pop();
        if(p.right != null) {
            TreeNode right = p.right;
            while(right != null) {
                s.push(right);
                right = right.left;
            }
        }
        return p.val;
    }
}
