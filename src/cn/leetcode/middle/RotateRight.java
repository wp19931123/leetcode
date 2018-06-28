package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        //求链表的长度
        ListNode p = head;
        int len = 0;
        while(p != null) {
           len++;
           p = p.next;
        }
        int step = k % len;
        if(step == 0) {
            return head;
        }
        p = head;
        for(int i = 0;i < len-step-1;i++) {
            p = p.next;
        }
        ListNode newHead = p.next; //
        ListNode tail = p.next;
        p.next = null;
        for(int i = 0;i < step-1;i++) {
            tail = tail.next;
        }
        tail.next = head;

        return newHead;
    }
}
