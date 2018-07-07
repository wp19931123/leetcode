package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); ++i) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }

    //二进制int转换为格雷码的int
    public int binaryToGray(int num) {
        return (num >> 1) ^ num;
    }

    public int grayToBinary(int num) {
        int mask;
        for (mask = num >> 1; mask != 0; mask = mask >> 1) {
            num = num ^ mask;
        }
        return num;
    }
}
