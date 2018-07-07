package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

import java.util.Stack;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> s = new Stack<>();
        ListNode p = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode next = null;
        if(m > 1 ) {
            for(int i = 1;i < m - 1;i++) {
                p = p.next;
            }
            pre = p;
            p = p.next;
        }

        int count = 0;
        while(p != null && count <= (n-m)) {
            s.push(p);
            count++;
            p = p.next;
        }
        next = p;
        while(!s.isEmpty()) {
            pre.next = s.pop();
            pre = pre.next;
        }
        pre.next = next;

        return newHead.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode c = newHead;

        for (int i = 0; i < m - 1; i++) {
            c = c.next;
        }

        ListNode p = c.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = c.next;
            c.next = tmp;
        }
        return newHead.next;
    }
}
