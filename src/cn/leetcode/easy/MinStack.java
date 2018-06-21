package cn.leetcode.easy;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

public class MinStack {

    Stack<Integer> pushStack = new Stack();
    Stack<Integer> minStack = new Stack();
    public MinStack() {

    }

    public void push(int x) {
        pushStack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else {
            if (minStack.peek() > x) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        if(!pushStack.isEmpty()) {
            pushStack.pop();
        }else{
            throw new RuntimeException("stack is empty");
        }
        minStack.pop();
    }

    public int top() {
        if(!pushStack.isEmpty()) {
            return pushStack.peek();
        }else{
            throw new RuntimeException("stack is empty");
        }
    }

    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.peek();
        }else{
            throw new RuntimeException("stack is empty");
        }
    }
}
