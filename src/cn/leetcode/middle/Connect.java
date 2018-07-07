package cn.leetcode.middle;

/**
 * 给定一个二叉树
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 说明:
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 */
public class Connect {


    //递归遍历二叉树左侧节点，每一层往右遍历当前层节点，同时让下一层子节点往右指。
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        TreeLinkNode node = root;
        while (root != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            root = root.next;
        }
        connect(node.left);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

