package cn.leetcode.easy;


/**
 * 删除链表中重复的节点，只保留一个
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
        while(n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }

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
