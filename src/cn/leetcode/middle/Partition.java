package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        ListNode old = head;
        ListNode node = head;
        //找到第一个不小于x的节点
        while(node != null) {
            if(head.val >= x) {
                old = head;
            }
        }
        while (head != null) {
            if(head.val < x) {
                tmp.next = head;
                tmp = tmp.next;
            }
            head = head.next;
        }
        tmp.next = old;
        //从old开始删除下面的小于节点
        ListNode pre = null;
        ListNode cur = old;
        while(cur.next)

        return newHead.next;
    }
}
