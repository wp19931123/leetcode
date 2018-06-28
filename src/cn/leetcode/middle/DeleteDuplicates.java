package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * Given1->2->3->3->4->4->5, return1->2->5.
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);  //[1,2,3,3,4,4,5]
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n1 = new DeleteDuplicates().deleteDuplicates(n1);
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newhead = new ListNode(-1);
        ListNode tmp = newhead;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
            }
        }
        tmp.next = head;

        return newhead.next;
    }
}
