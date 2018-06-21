package cn.leetcode.easy;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return  null;
        }
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
