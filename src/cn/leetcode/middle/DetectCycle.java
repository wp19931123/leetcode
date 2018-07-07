package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = l1;
        System.out.print(new DetectCycle().detectCycle(l1).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                if(slow == head) {
                    return head;
                }
                slow = head;
                while (slow != null) {
                    slow = slow.next;
                    fast = fast.next;
                    if (slow == fast) {
                        return slow;
                    }
                }
            }
        }
        return null;
    }
}
