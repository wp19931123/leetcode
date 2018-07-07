package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 对链表进行插入排序。
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l1 = new InsertionSortList().insertionSortList(l1);
        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                ListNode q = newHead;
                ListNode tmp = p.next;
                p.next = p.next.next;
                //这时由于p已经比tmp.val大了，只需要从前往后找到第一个比其大的前一个位置即可
                while (q.next.val < tmp.val) {
                    q = q.next;
                }
                //插入过程
                tmp.next = q.next;
                q.next = tmp;

            }
        }

        return newHead.next;
    }
}
