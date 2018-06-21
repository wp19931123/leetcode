package cn.leetcode.easy;

import java.util.Stack;

/**
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;l2.next = l3;l3.next = null;
        System.out.println(new ReverseList().reverseListI(l1).val);
    }
    //递归
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = null;
        while(head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
    //非递归
    public ListNode reverseListI(ListNode head) {
        return reverseList(head,null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if(head == null) {
            return newHead;
        }
        ListNode nextNode = head.next;
        head.next = newHead;
        return reverseList(nextNode,head);
    }

    //  利用栈的性质
    public ListNode reverseList2(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = stack.pop();
        ListNode node = res;
        while(!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        return res;
    }
}
