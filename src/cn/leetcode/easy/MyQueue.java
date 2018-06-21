package cn.leetcode.easy;

import java.util.Stack;

/**
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size,
 * 和 is empty 操作是合法的。
 */
public class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }else{
            return s2.pop();
        }

    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }else{
            return s2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

}
