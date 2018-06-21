package cn.leetcode.easy;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nLast = null;
        if(root == null) {
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
                nLast = node.left;
            }
            if(node.right != null) {
                queue.offer(node.right);
                nLast = node.right;
            }
            //需要换行了
            if(last == node) {
                last = nLast;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }

        }
        Collections.reverse(res);
        return res;
    }

}
