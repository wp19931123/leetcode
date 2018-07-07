package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        TreeNode n = root;
        TreeNode nLast = root;
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
            if(n == node) {
                n = nLast;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        return res;
    }
}
