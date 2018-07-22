package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        System.out.print(new RightSideView().rightSideView(t1));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //找到每一层最右的节点
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode n = root;
        TreeNode nLast = root;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                q.offer(node.right);
                nLast = node.right;
            }
            if (n == node) {
                n = nLast;
                res.add(node.val);
            }
        }

        return res;
    }
}
