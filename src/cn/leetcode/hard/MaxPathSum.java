package cn.leetcode.hard;

import cn.leetcode.middle.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 示例 1:
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.print(new MaxPathSum().maxPathSum(t1));
    }

    /**
     * 对于指定某个节点为根时，最大的路径和有可能是哪些情况:
     * 1,左子树的路径加上当前节点
     * 2,右子树的路径加上当前节点
     * 3，左右子树的路径加上当前节点
     * 4，只有当前节点
     * 这四种情况只是用来计算以当前节点根的最大路径，如果当前节点上面还有节点，
     * 那它的父节点是不能累加第三种情况的。所以我们要计算两个最大值，一个是当前节点下最大路径和，
     * 另一个是如果要连接父节点时最大的路径和。我们用前者更新全局最大量，用后者返回递归值就行了
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        //连接父节点的最大路径,1,2,4三种情况最大值
        int curSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        //当前节点的最大路径，1，2，3，4四种情况最大值
        int curMax = Math.max(curSum, left + right + root.val);
        //用当前最大来更新全局最大
        max = Math.max(curMax, max);
        return curSum;
    }
}
