package cn.leetcode.middle;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 你可以假设所给定的表达式都是有效的。请不要使用内置的库函数 eval。
 * 示例 1:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.print(new Calculate().calculate("3+5 / 2 "));
    }

    /**
     * 由于存在运算优先级，我们采取的措施是使用一个栈保存数字，
     * 如果该数字之前的符号是加或减，那么把当前数字压入栈中，注意如果是减号，则加入当前数字的相反数，
     * 因为减法相当于加上一个相反数。如果之前的符号是乘或除，那么从栈顶取出一个数字和当前数字进行乘或除的运算，
     * 再把结果压入栈中，那么完成一遍遍历后，所有的乘或除都运算完了，再把栈中所有的数字都加起来就是最终结果了
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int res = 0, num = 0, n = s.length();
        char op = '+';
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                num = num * 10 + ch - '0';
            }
            if ((ch < '0' && ch != ' ') || i == n - 1) {
                if (op == '+') st.push(num);
                if (op == '-') st.push(-num);
                if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? st.peek() * num : st.peek() / num;
                    st.pop();
                    st.push(tmp);
                }
                op = ch;
                num = 0;
            }
        }
        while (!st.empty()) {
            res += st.pop();
        }
        return res;
    }

    public int calculate2(String s) {
        int res = 0, curRes = 0, num = 0, n = s.length();
        char op = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == n - 1) {
                switch (op) {
                    case '+':
                        curRes += num;
                        break;
                    case '-':
                        curRes -= num;
                        break;
                    case '*':
                        curRes *= num;
                        break;
                    case '/':
                        curRes /= num;
                        break;
                }
                if (ch == '+' || ch == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = ch;
                num = 0;
            }
        }

        return res;
    }
}
