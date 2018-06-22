package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 给定的 n 保证是有效的。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        //求链表的长度
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        if(len == n) {
            return head.next;
        }
        //正数第len-n+1个
        ListNode p = head;
        int i = 1;
        while(i < len-n) {
            p = p.next;
            i++;
        }
        p.next = p.next.next;

        return head;
    }
}
