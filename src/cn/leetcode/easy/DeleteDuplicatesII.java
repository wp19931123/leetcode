package cn.leetcode.easy;


/**
 * Given1->2->3->3->4->4->5, return1->2->5.
 */
public class DeleteDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        while (node.next !=  null) {
            if (node.next.val == node.val) {
                node = node.next;
                pre.next = node;
            }else{
                pre = node;
                node = node.next;
            }
        }

        return head;
    }
}
