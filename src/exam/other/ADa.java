package exam.other;

import java.util.Stack;

public class ADa {

    private static final char[] NUMBERS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String[] OPERATORS = {"+", "-", ""};
    private static final int RESULT = 110;  // 计算结果

    public static void main(String[] args) {
        sortAndCompute(0, "");
    }

    private static void sortAndCompute(int numIndex, String buffer) {
        // 说明到最后一个字符了
        if (numIndex == NUMBERS.length - 1) {
            buffer += NUMBERS[numIndex];
            String formula = buffer.toString();
            if (sum(formula) == RESULT) {
                System.out.println(formula + " = " + RESULT);
            }
            return;
        }

        for (int operIndex = 0; operIndex < OPERATORS.length; ++operIndex) {
            buffer += NUMBERS[numIndex];
            buffer += OPERATORS[operIndex];
            sortAndCompute(numIndex + 1, buffer);
            // 消除前面两个已经添加的字符恢复原状，以便下一次循环的叠加
            // 但是当中间连接符变为''的时候，则只删除buffer中的前面一个字符
            buffer = operIndex != 2 ? buffer.substring(0, buffer.length() - 2)
                    : buffer.substring(0, buffer.length() - 1);
        }
    }

    private static int sum(String formula) {
        if (formula == null || formula.trim().length() == 0)
            throw new IllegalArgumentException("formula is invalid!");

        Stack<String> numStack = new Stack<String>();
        Stack<String> operStack = new Stack<String>();
        StringBuffer numBuffer = new StringBuffer();

        formula += "#";    // 添加一个结束符到公式末尾便于计算
        char[] chs = formula.toCharArray();
        for (int index = 0; index < formula.length(); ++index) {
            if (chs[index] != '+' && chs[index] != '-' && chs[index] != '#') {
                numBuffer.append(chs[index]);
            } else {
                numStack.push(numBuffer.toString());
                numBuffer.delete(0, numBuffer.length());

                if (operStack.isEmpty()) operStack.push(chs[index] + "");
                else {
                    int numAft = Integer.parseInt(numStack.pop());
                    int numBef = Integer.parseInt(numStack.pop());
                    String oper = operStack.pop();
                    int sum = oper.equals("+") ? numBef + numAft : numBef - numAft;
                    numStack.push(sum + "");
                    operStack.push(chs[index] + "");
                }
            }
        }
        return Integer.parseInt(numStack.pop());
    }
}
