package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        System.out.print(new PathSum().pathSum(t1, 26));
    }

    List<List<Integer>> res;
    List<Integer> tmp;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        if (root == null) {
            return res;
        }
        tmp.add(root.val);
        dfs(root, sum);
        tmp.remove(tmp.size()-1);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if(root.left != null) {
            tmp.add(root.left.val);
            dfs(root.left,sum-root.val);
            tmp.remove(tmp.size()-1);
        }
        if(root.right != null) {
            tmp.add(root.right.val);
            dfs(root.right,sum-root.val);
            tmp.remove(tmp.size()-1);
        }
    }
}
