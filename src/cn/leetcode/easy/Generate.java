package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i =1;i <= numRows;i++) {
            List<Integer> tmp = new ArrayList<>();;
            for(int j = 1;j <=i;j++) {
                if(j == 1 || j == i) {
                    tmp.add(1);
                }else{
                    tmp.add(res.get(i-2).get(j-2)+res.get(i-2).get(j-1));
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
