package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMode {

    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int max = 1;
    public int[] findMode(TreeNode root) {
        if(root != null) {
            if(map.containsKey(root.val)) {
                map.put(root.val,map.get(root.val)+1);
                if(map.get(root.val) > max) {
                    max = map.get(root.val);
                }
            }else{
                map.put(root.val,1);
            }
            findMode(root.left);
            findMode(root.right);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
              list.add(entry.getKey());
            }
        }
        int s = list.size();
        int[] res = new int[s];
        for(int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
