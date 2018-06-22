package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 答案中不可以包含重复的四元组。
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i < nums.length-3;i++){
            for(int j=i+1;j < nums.length-2;j++){
                int left = j+1;
                int right = nums.length-1;
                int reserve = target-nums[i]-nums[j];
                while(left < right){         //确定前面两个数，寻找后后面两个数
                    if(nums[left] + nums[right] > reserve){
                        right--;
                        continue;
                    }
                    if(reserve == nums[left] + nums[right]){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        result.add(item);

                    }
                    left++;
                    while(nums[left] == nums[left-1] && left < right ){ //第三个数相等时移动，避免重复
                        left++;
                    }

                }
                while(nums[j] == nums[j+1] && j < nums.length - 2){  //第二个数相等时移动
                    j++;
                }
            }
            while(nums[i] == nums[i+1] && i < nums.length-3 ){    //第一个数相等时移动
                i++;
            }
        }
        return result;
    }
}
