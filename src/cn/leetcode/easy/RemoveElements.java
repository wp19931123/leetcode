package cn.leetcode.easy;

public class RemoveElements {

    public static void main(String[] args) {
        //1,2,6,3,4,5,6
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;
        System.out.print(new RemoveElements().removeElements(l1,6));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode newL = null;
        while(node != null && node.val == val) {
            node = node.next;
        }
        newL = node;
        ListNode nHead = node;
        ListNode p = node.next;
        while(p != null) {
            if(p.val != val) {
                newL.next = p;
                newL = newL.next;
            }
            p = p.next;
        }
        return nHead;
    }

}
