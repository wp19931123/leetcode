package cn.leetcode.middle;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] arr = {"2","1","+","3","*"};
        System.out.print(new EvalRPN().evalRPN(arr));
    }

    //后缀表达式求值，用栈即可
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i < tokens.length;i++) {
            if(tokens[i].equals("+")) {  //leetcode用==报错
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b+a);
            }else if(tokens[i].equals("-")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b-a);
            }else if(tokens[i].equals("*")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b*a);
            }else if(tokens[i].equals("/")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b/a);
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.pop();
    }
}
