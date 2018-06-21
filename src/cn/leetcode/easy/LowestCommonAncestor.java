package cn.leetcode.easy;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 一个节点也可以是它自己的祖先
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        //两个节点都位于左子树上
        if(p.val < root.val && q.val < root.val) {
           return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val) {
            //两个节点都位于右子树上
            return lowestCommonAncestor(root.right,p,q);
        }else{
            //一个位于左子树一个位于右子树或者其中一个位于root
            return root;
        }
    }

}
