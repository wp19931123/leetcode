package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
    //  利用List，提示超时
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            if(list.contains(i)) {
                return true;
            }else{
                list.add(i);
            }
        }
        return false;
    }

    //  利用排序
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}


