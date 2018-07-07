package cn.leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    //层次遍历打印
    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode n = root;
        TreeNode nLast = root;
        int row = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nLast = node.right;
            }
            if (n == node) {
                n = nLast;
                System.out.println();
            }
        }
    }
}
