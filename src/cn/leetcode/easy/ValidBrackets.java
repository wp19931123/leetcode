package cn.leetcode.easy;

import java.util.Stack;

/**
 * 打开的括号必须用相同类型的括号关闭。
 * 打开的括号必须按照正确的顺序关闭。
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(new ValidBrackets().isValid(str));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else if(ch == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.pop() != '(') {
                    return false;
                }
            }else if(ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.pop() != '[') {
                    return false;
                }
            }else{
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.pop() != '{') {
                    return false;
                }
            }

        }
        if(!stack.isEmpty()) {
            return false;
        }
        return  true;
    }
}
