package cn.leetcode.extend;

import cn.leetcode.middle.TreeNode;

import java.util.*;

//二叉树的几种非递归遍历
public class BinTreeOrder {

    /**
     * 非递归先序遍历二叉树
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) //如果为空树则返回
            return res;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur != null) {
                res.add(cur.val);//访问根节点
                s.push(cur.right); //入栈右孩子
                s.push(cur.left);//入栈左孩子
            }
        }
        return res;
    }

    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    //后序
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}
