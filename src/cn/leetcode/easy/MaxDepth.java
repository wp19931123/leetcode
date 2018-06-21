package cn.leetcode.easy;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left >= right ? left+1 : right+1;
    }

}