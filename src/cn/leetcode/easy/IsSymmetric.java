package cn.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    //递归形式，前序遍历（先左后右，先右后左）
    public boolean isSymmetric(TreeNode p1,TreeNode p2) {
        if(p1 == null && p2 == null) {
            return true;
        }else if(p1 != null && p2 != null) {
            if(p1.val != p2.val) {
                return false;
            }else{
                return isSymmetric(p1.left,p2.right) && isSymmetric(p1.right,p2.left);
            }
        }else{
            return false;
        }
    }
    //非递归形式，用队列存储遍历到的节点
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        TreeNode left,right;
        q1.offer(root.left);
        q2.offer(root.right);
        while(q1 != null && q2 != null) {
            left = q1.poll();
            right = q2.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }

        return true;
    }

}
