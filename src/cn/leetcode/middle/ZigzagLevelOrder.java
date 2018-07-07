package cn.leetcode.middle;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *例如：给定二叉树
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrder {

    //利用两个栈来实现
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()) {
                //s1不空,s2空
                while(!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    tmp.add(node.val);
                    if(node.left != null) {
                        s2.push(node.left);
                    }
                     if(node.right != null) {
                        s2.push(node.right);
                     }
                }
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }else{
                //s1空,s2不空
                while(!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    tmp.add(node.val);
                    if(node.right != null) {
                        s1.push(node.right);
                    }
                    if(node.left != null) {
                        s1.push(node.left);
                    }
                }
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }

        return res;
    }
}
