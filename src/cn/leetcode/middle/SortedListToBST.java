package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if(head == tail) {
            return null;
        }
        if(head.next == tail) {
            TreeNode node = new TreeNode(head.val);
            return node;
        }
        ListNode mid = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head, mid);
        node.right = sortedListToBST(mid.next, tail);

        return node;
    }
}
