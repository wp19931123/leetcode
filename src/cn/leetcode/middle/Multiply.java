package cn.leetcode.middle;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * num1 和 num2 的长度小于110。不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {

    //转换下字符串到数字数组，让乘数的每一个数字分别和被乘数相乘，注意进位，记得对准位置就好。
    //一般来说保存结果的数组，可以预先估计下最大可能的长度，比如我选择了两个数组的长度之和，这样运算的时候就不用担心空间不够。
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int n = nums1.length, m = nums2.length, i, j, k;
        //一般来说两个数相乘，其最大位数也不会大于两个数的位数之和
        int[] result = new int[n + m];
        //转换成数字
        for (i = 0; i < n; i++)
            nums1[i] -= '0';
        for (i = 0; i < m; i++)
            nums2[i] -= '0';
        //用nums2的每一位去乘nums1 累加到result
        for (i = 0; i < m; i++) {
            int carry = 0;
            for (j = 0; j < n; j++) {
                result[i + j] = result[i + j] + nums2[m - 1 - i] * nums1[n - 1 - j] + carry;
                carry = result[i + j] / 10;
                result[i + j] %= 10;
            }
            k = i + j;
            //处理进位
            while (carry != 0) {
                result[k] += carry;
                carry = result[k] / 10;
                result[k] %= 10;
                k++;
            }
        }
        StringBuilder tmp = new StringBuilder(n + m);
        i = m + n - 1;
        while (i > 0 && result[i] == 0)
            i--;
        while (i >= 0)
            tmp.append(result[i--]);
        return tmp.toString();
    }
}
