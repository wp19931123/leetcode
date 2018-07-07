package cn.leetcode.middle;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode node = head;
        //在每个节点后添加复制节点
        while(node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        //给每个复制节点赋random值
        node = head;
        while(node != null) {
            RandomListNode copy = node.next;
            if(node.random != null) {
                copy.random = node.random.next;
            }
            node = copy.next;
        }
        //拆分大链表
        RandomListNode newHead = head.next;
        RandomListNode newnode = newHead;
        node = head;
        while(node != null) {
            newnode = node.next;
            node.next = newnode.next;
            node = node.next;
            if(node != null) {
                newnode.next = node.next;
            }
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
