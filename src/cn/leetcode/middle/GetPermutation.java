package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 给定 n 的范围是 [1, 9]。给定 k 的范围是[1,  n!]。
 */
public class GetPermutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        String res = new GetPermutation().getPermutation(9,94626);
        System.out.print(res);
    }

    public String getPermutation(int n, int k) {
        

        return null;
    }

    //超出时间限制
    public String getPermutation2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++) {
            nums[i] = i+1;
        }
        res =  allSort(nums,0,n-1,res);
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for(int i = 0;i < o1.size();i++) {
                    if(o1.get(i) != o2.get(i)) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
        List<Integer> kList = res.get(k-1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < kList.size();i++) {
            sb.append(kList.get(i));
        }
        return sb.toString();
    }

    private List<List<Integer>> allSort(int[] nums, int begin, int end,List<List<Integer>> list) {
        if(begin == end) {
            List<Integer> tmp = new ArrayList();
            for(int i : nums) {
                tmp.add(i);
            }
            list.add(tmp);
            return list;
        }
        for(int i = begin;i <= end;i++) {
            swap(nums,begin,i);
            allSort(nums,begin+1,end,list);
            swap(nums,begin,i);
        }
        return list;
    }

    private void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
