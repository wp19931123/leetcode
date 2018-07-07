package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null) {
            TreeNode l = findBig(root.left);
            if(root.val <= l.val) {
                return false;
            }
        }
        if(root.right != null) {
            TreeNode r = findSmall(root.right);
            if(root.val >= r.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public TreeNode findBig(TreeNode left) {
        while(left.right != null) {
            left = left.right;
        }
        return left;
    }
    public TreeNode findSmall(TreeNode right) {
        while(right.left != null) {
            right = right.left;
        }
        return right;
    }
}
