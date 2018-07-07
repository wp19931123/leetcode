package cn.leetcode.middle;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.print(new SumNumbers().sumNumbers(t1));
    }

    int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }


    private int dfs(TreeNode root, int tmp) {
        if (root == null) {
            return res;
        }
        tmp = tmp * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += tmp;
        }
        dfs(root.left, tmp);
        dfs(root.right, tmp);
        tmp /= 10;
        return res;
    }
}
