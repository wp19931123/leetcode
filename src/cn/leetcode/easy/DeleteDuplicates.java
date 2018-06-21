package cn.leetcode.easy;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode node = head;
        while(node.next != null) {
            if(node.next.val == node.val) {
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }

}
