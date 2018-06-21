package cn.leetcode.easy;

import java.util.ArrayList;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * input:3
 * output:[1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRow {

    public static void main(String[] args) {
        System.out.print(new GetRow().getRow(3));
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0;i < rowIndex;i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0;j <= i;j++) {
                if(j == 0 || j == i) {
                    tmp.add(1);
                }else{
                    tmp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j)); //
                }
                res.add(tmp);
            }
        }
        return res.get(rowIndex);
    }

}
