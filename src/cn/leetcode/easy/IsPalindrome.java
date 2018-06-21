package cn.leetcode.easy;

import java.util.Stack;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.print(new IsPalindrome().isPalindrome(test));
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        l1.next = l2;
        System.out.println(new IsPalindrome().isPalindrome(l1));
    }

    /**
     * 请判断一个链表是否为回文链表。
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        while(head != null) {
            if(head.val == stack.pop().val) {
                head = head.next;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * 借鉴“判断链表是否有环”思想利用快慢指针法找到链表中点，然后一个将后半部分就地反转，
     * 分别再从头、中点遍历判断是否相等，该方法时间复杂度O(n)、空间复杂度O(1).
     * @param head
     * @return
     */
    public boolean isPalindromeList(ListNode head) {
        if(head == null) {
            return true;
        }
        //查找链表中点
        ListNode middle = findMiddle(head);

        //反转链表
        ListNode tail = reverse(middle);
        //遍历
        while(head != null) {
            if(head.val != tail.val) {
                return false;
            }else{
                head = head.next;
                tail = tail.next;
            }
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head;
        while(q != null && q.next != null){
            p = p.next;
            q = q.next.next;
        }

        return p;
    }

    public ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = null;
        while(head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        char[] ch = str.toCharArray();
        int i = 0;
        while(i <= ch.length/2) {
            if(ch[i] == ch[ch.length - 1 -i]) {
                i++;
            }else{
                return false;
            }
        }
        return false;
    }

    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //说明：本题中，我们将空字符串定义为有效的回文串。
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        String str = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
           if(isNumOrChar(str.charAt(left)) && isNumOrChar(str.charAt(right))) {
                if(str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                }else{
                    return false;
                }
           }else if(!isNumOrChar(str.charAt(left))){
                left++;
           }else if(!isNumOrChar(str.charAt(right))) {
                right--;
            }else{
               left++;
               right--;
            }
        }
        return true;
    }
    public static boolean isNumOrChar(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }else{
            return false;
        }
    }
}
