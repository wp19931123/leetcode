package cn.leetcode.middle;

import cn.leetcode.easy.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);  //[1,2,3,3,4,4,5]
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n1 = new Partition().partition(n1,3);
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        ListNode old = head;
        ListNode node = head;
        //找到第一个不小于x的节点
        while(node != null) {
            if(node.val >= x) {
                old = node;
                break;
            }
            node = node.next;
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
        ListNode pre = old;
        ListNode cur = old.next;
        while(cur != null) {
            if(cur.val < x) {
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }

        return newHead.next;
    }
}
