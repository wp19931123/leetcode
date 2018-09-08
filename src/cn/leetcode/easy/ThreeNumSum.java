package cn.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeNumSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeNumSum tns = new ThreeNumSum();
        List<List<Integer>> list = tns.threeSum2(nums);
        System.out.println(list);
    }

    //递归
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        //1，首先进行排序
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum2(nums, i, i + 1, nums.length - 1, result, tmp);
        }
        return result;
    }

    private void threeSum2(int[] nums, int index, int left, int right, List<List<Integer>> res, List<Integer> tmp) {
        if (left < right) {
            int sum = nums[left] + nums[right];
            if (sum + nums[index] == 0) {
                tmp.add(nums[index]);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
                threeSum2(nums, index, left, right, res, tmp);
            } else if (sum + nums[index] < 0) {
                threeSum2(nums, index, left + 1, right, res, tmp);
            } else {
                threeSum2(nums, index, left, right - 1, res, tmp);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        //1，首先进行排序
        Arrays.sort(nums);
        int sum, left, right;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //先确定一个位置i，然后再确定后两个数
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum + nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
