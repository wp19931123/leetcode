package cn.leetcode.middle;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        //中序遍历
        TreeNode cur = root;
        int count = 0;  //计数
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || cur != null) {
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            count++;
            if(count == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }
}
