package cn.leetcode.easy;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int lenL = maxDepth(root.left);
        int lenR = maxDepth(root.right);
        if(lenL - lenR > 1 || lenL - lenR < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left >= right ? left+1 : right+1;
    }
}
