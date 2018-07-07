package cn.leetcode.middle;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    List<Integer> list = new ArrayList<>();
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        if(root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }

    //非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        if(root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        while(cur != null || !s.isEmpty()) {
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if(!s.isEmpty()) {
                cur = s.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }
}
