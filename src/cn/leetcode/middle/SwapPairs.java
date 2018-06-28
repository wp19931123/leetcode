package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    //通过交换节点的值
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p = head;
        while(p != null && p.next != null) {
            int tmp = p.val;
            p.val = p.next.val;
            p.next.val = tmp;
            p = p.next.next;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode p = new ListNode(-1);
        ListNode pre = p;
        pre.next = head;
        while(pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode late = node2.next;

            pre.next = node2;
            node2.next = node1;
            node1.next = late;

            pre = node1;
        }

        return p.next;
    }
}
