package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;l5.next = l6;
        System.out.println(new AddTwoNumbers().addTwoNumbers(l1,l4).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start1 = l1;
        ListNode start2 = l2;
        ListNode res;
        int up = 0;
        if(start1.val + start2.val >= 10) {
            res = new ListNode(start1.val + start2.val - 10);
            up = 1;
        }else{
            res = new ListNode(start1.val + start2.val);
        }

        ListNode node = res;
        start1 = start1.next;
        start2 = start2.next;
        while(start1 != null && start2 != null) {
            int value = start1.val + start2.val + up;
            if(value >= 10) {
                node.next = new ListNode(value-10);
                up = 1;
                node = node.next;
            }else{
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        while(start1 != null) {
            int value = start1.val + up;
            if(value >= 10) {
                node.next = new ListNode(value-10);
                up = 1;
                node = node.next;
            }else{
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start1 = start1.next;
        }
        while(start2 != null) {
            int value = start2.val + up;
            if(value >= 10) {
                node.next = new ListNode(value-10);
                up = 1;
                node = node.next;
            }else{
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start2 = start2.next;
        }
        if(up == 1) {
            node.next = new ListNode(1);
        }

        return res;
    }
}
