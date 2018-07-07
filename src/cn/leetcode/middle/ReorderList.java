package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new ReorderList().reorderList(l1);
        while(l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        mid = reverse(mid);  //反转链表
        //切断
        slow.next = null;
        ListNode node = head;
        //重新连接
        while(mid != null) {
            ListNode tmp = node.next;
            node.next = mid;
            mid = mid.next;
            node = node.next;
            node.next = tmp;
            node = node.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
