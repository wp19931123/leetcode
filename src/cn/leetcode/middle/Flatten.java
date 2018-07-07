package cn.leetcode.middle;


/**
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten {
    /**
     * 使用递归的思想，首先使用DFS思路找到左子树的最左节点，然后将该最左节点的父节点和右子树断开，
     * 把该最左节点连接到父节点的右节点上，左节点置为null，再把原右子树连接到原左子树的最右节点上，再往上遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        //找最左节点
        if(root.left != null) {
            flatten(root.left);
        }
        if(root.right != null) {
            flatten(root.right);
        }
        //把父节点和右节点断开
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        //把右节点连接到新右节点的最右节点上
        while(root.right != null) {
            root = root.right;
        }
        root.right = tmp;

    }
    //迭代写法
    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                //找到左子树的最右节点 目的是把原右子树连接到该节点的右节点上
                TreeNode p = cur.left;
                while(p.right != null) {
                    p = p.right;
                }
                //断开父节点和右节点
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }

    }


}
