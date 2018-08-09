package cn.leetcode.middle;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。
 */
public class LowestCommonAncestor {

    //自顶向下
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (hasNode(root.left, p) && hasNode(root.left, q)) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (hasNode(root.right, p) && hasNode(root.right, q)) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }

    private boolean hasNode(TreeNode node, TreeNode p) {
        if (node == null) {
            return false;
        }
        while (node == p) {
            return true;
        }
        return hasNode(node.left, p) || hasNode(node.right, p);
    }


    //自底向上
    //一旦遇到结点等于p或者q，则将其向上传递给它的父结点。父结点会判断它的左右子树是否都包含其中一个结点，
    // 如果是，则父结点一定是这两个节点p和q的LCA，传递父结点到root。
    // 如果不是，我们向上传递其中的包含结点p或者q的子结点，或者NULL(如果子结点不包含任何一个)。该方法时间复杂度为O(N)。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if (L != null && R != null) {
            return root;  // 如果p和q位于不同的子树
        }
        return L != null ? L : R;  //p和q在相同的子树，或者p和q不在子树中
    }
}
