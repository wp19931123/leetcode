package cn.leetcode.easy;

public class HasCycle {

    public static void main(String[] args) {
        System.out.print(new HasCycle().hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

}
