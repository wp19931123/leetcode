package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 */
public class Permute {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = new Permute().permute(arr);
        System.out.print(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) {
            return res;
        }
        int len = nums.length;
        return allSort(nums,0,len-1,res);
    }

    /**
     * 1.首先将1固定，递归求子数组[2,3]的全排列；
     * 2.将1和2交换，递归求[1,3]的全排列；
     * 3.因为第二步中1和2进行了交换，因此需要再把1交换回来，交换回来之后再将1和3进行交换，再递归求[1,2]的全排列。
     * @param nums
     * @param begin
     * @param end
     * @param list
     * @return
     */
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
