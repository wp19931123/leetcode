package cn.leetcode.easy;

/**
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lenL = minDepth(root.left);
        int lenR = minDepth(root.right);
        if(lenL == 0 && lenR == 0) {
            return 1;
        }
        if(lenL == 0 ) {
            return lenR+1;
        }
        if(lenR == 0) {
            return lenL+1;
        }
        return lenL < lenR ? lenL + 1 : lenR + 1;
    }
}
