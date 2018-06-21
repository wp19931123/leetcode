package cn.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 */
public class FindRelativeRanks {

    public static void main(String[] args) {
        int[] strs = {5,4,3,2,1};
        String[] res = new FindRelativeRanks().findRelativeRanks(strs);
        for(String s : res) {
            System.out.print(s+" ");
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.put(i,nums[i]);
        }
        Arrays.sort(nums);
        //遍历map
        int sIndex = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            //二分查找
            int index = search(nums,0,nums.length-1,val);
            if(index == nums.length-1) {
                res[sIndex++] = "Gold Medal";  //"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"
            }else if(index == nums.length-2) {
                res[sIndex++] = "Silver Medall";
            }else if(index == nums.length-3) {
                res[sIndex++] = "Bronze Medal";
            }else{
                res[sIndex++] = Integer.toString(nums.length- index);
            }

        }
        return res;
    }
    public int search(int[] arr,int start,int end,int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > target) {
                end = mid - 1;
            }else if(arr[mid] < target) {
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
 }
