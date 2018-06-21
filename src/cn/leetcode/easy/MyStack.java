package cn.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack.top());
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            throw new RuntimeException("stack is empty");
        }
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            throw new RuntimeException("stack is empty");
        }
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.peek();
        q2.offer(q1.poll());
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
