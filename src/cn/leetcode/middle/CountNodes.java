package cn.leetcode.middle;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        int h = height(root);
        int nums = 0;
        while(root != null) {
            if(h-1 == height(root.right)) {
                //左子树是满的
                nums += 1<<h-1;
                root = root.right;
            }else{
                //右子树是满的
                nums+=1<<h-2;
                root=root.left;
            }
            h--;
        }
        return nums;
    }

    //求完全二叉树的高度
    private int height(TreeNode root) {
        return root == null ? 0 : height(root.left) + 1;
    }

    //超出时间限制
    public int countNodes1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root != null) {
            count += countNodes1(root.left) + countNodes1(root.right) + 1;
        }
        return count;

    }
}
