package exam.shunwang;

public class Main {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start1 = l1;
        ListNode start2 = l2;
        ListNode res;
        int up = 0;
        if (start1.val + start2.val >= 10) {
            res = new ListNode(start1.val + start2.val - 10);
            up = 1;
        } else {
            res = new ListNode(start1.val + start2.val);
        }

        ListNode node = res;
        start1 = start1.next;
        start2 = start2.next;
        while (start1 != null && start2 != null) {
            int value = start1.val + start2.val + up;
            if (value >= 10) {
                node.next = new ListNode(value - 10);
                up = 1;
                node = node.next;
            } else {
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        while (start1 != null) {
            int value = start1.val + up;
            if (value >= 10) {
                node.next = new ListNode(value - 10);
                up = 1;
                node = node.next;
            } else {
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start1 = start1.next;
        }
        while (start2 != null) {
            int value = start2.val + up;
            if (value >= 10) {
                node.next = new ListNode(value - 10);
                up = 1;
                node = node.next;
            } else {
                node.next = new ListNode(value);
                up = 0;
                node = node.next;
            }
            start2 = start2.next;
        }
        if (up == 1) {
            node.next = new ListNode(1);
        }

        return res;
    }

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
