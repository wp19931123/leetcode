package cn.leetcode.extend;

import java.util.Stack;

/**
 * 后缀表达式又叫做逆波兰表达式。在通常的表达式中，二元运算符总是置于与之相关的两个运算对象之间，所以，这种表示法也称为中缀表示
 */
public class SuffixExpression {
    private String testString = null;
    private Stack<Character> stack = null;

    public static void main(String[] args) {
        SuffixExpression testStacknew = new SuffixExpression("A+B*(C-D)/E+F/H");
        testStacknew.suffixExpression();
    }


    public SuffixExpression(String testString) {
        this.testString = testString;
        this.stack = new Stack<>();
    }

    /**
     * 将中缀表达式转换为后缀表达式的算法思想：
     * 开始扫描；字符为
     * 　　1,数字时，加入后缀表达式；
     * 　　2,运算符时：
     * 　　 a. 若为最高级的运算符，入栈；
     * 　　 b. 若为 '('，入栈；
     * 　　 c. 若为 ')'，则依次把栈中的的运算符加入后缀表达式中，直到出现'('，从栈中删除'(' ；
     * 　　 d. 若为不是最高级的运算符，则将从栈顶到第一个优先级不大于它的运算符（或 '(',但优先满足前一个条件）
     *        之间的运算符加入后缀表达式中，该运算符再入栈；
     */
    private void suffixExpression() {
        for (int i = 0; i < testString.length(); i++) {
            char c = testString.charAt(i);
            if (c == '+' || c == '-') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                            && (stack.peek() == '*' || stack.peek() == '/'
                            || stack.peek() == '+' || stack.peek() == '-')) {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '*' || c == '/') {
                if (stack.isEmpty() || stack.peek() == '+'
                        || stack.peek() == '-' || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                            && (stack.peek() == '/' || stack.peek() == '*')) {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                char temp = ' ';
                while ((temp = stack.pop()) != '(') {
                    System.out.print(temp);
                }
            } else {
                System.out.print(c);
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
