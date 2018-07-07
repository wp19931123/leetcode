package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class PreorderTraversal {

    List<Integer> res = new ArrayList<>();

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    /**
     * 非递归
     * 头结点压栈，然后，每次弹出栈顶元素，如果右孩子不为空，右孩子入栈，
     * 如果左孩子不空，左孩子入栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            if(node != null) {
                res.add(node.val);//访问根节点
                s.push(node.right); //入栈右孩子
                s.push(node.left);//入栈左孩子
            }
        }
        return res;
    }
}
