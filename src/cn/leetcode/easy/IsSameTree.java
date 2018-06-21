package cn.leetcode.easy;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        //遍历第一棵树
        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left) &&  isSameTree(p.right,q.right);
    }
}
