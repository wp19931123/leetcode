package cn.leetcode.easy;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lenA = 0;
        int lenB = 0;
        while(p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while(p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        int dif = lenA - lenB;
        if(dif > 0) {
            p1 = headA;
            p2 = headB;
        }else{
            p1 = headB;
            p2 = headA;
        }
        for(int i = 0;i < dif;i++) {
            p1 = p1.next;
        }
        while(p1 != null && p2 != null) {
            if(p1 == p2) {
                return p1;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }
}
