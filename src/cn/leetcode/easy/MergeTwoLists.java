package cn.leetcode.easy;

import java.util.ArrayList;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(new MergeTwoLists().mergeTwoLists(null,null));
    }
    //Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    public ListNode mergeKLists(ArrayList<ListNode> lists) {


        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode result,cur;
        if(next1.val <= next2.val) {
            cur = new ListNode(next1.val);
            result = cur;
            next1 = next1.next;
        }else{
            cur = new ListNode(next2.val);
            result = cur;
            next2 = next2.next;
        }
        while(next1 !=  null && next2 != null) {
            if(next1.val <= next2.val) {
                cur.next = next1;
                cur = cur.next;
                next1 = next1.next;
            }else{
                cur.next = next2;
                cur = cur.next;
                next2 = next2.next;
            }
        }
        while(next1 != null) {
            cur.next = next1;
            cur = cur.next;
            next1 = next1.next;
        }
        while(next2 != null) {
            cur.next = next2;
            cur = cur.next;
            next2 = next2.next;
        }
        return result;
    }
}
