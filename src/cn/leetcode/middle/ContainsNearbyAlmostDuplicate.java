package cn.leetcode.middle;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 */
public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        int[] arr = {2147483647, -2147483647};
        System.out.print(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(arr, 1, 2147483647));
    }

    /**
     * 暴力：超时
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                long dis = Math.abs((long) nums[i] - (long) nums[j]);
                if (dis >= -t && dis <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    //存储索引和值
    class Ele {
        int index;
        int val;

        public Ele(int i, int v) {
            index = i;
            val = v;
        }
    }

    //自定义一个数据结构存储索引和值
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        List<Ele> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Ele ele = new Ele(i, nums[i]);
            list.add(ele);
        }
        Collections.sort(list, new Comparator<Ele>() {
            @Override
            public int compare(Ele o1, Ele o2) {
                long l = (long) o1.val - (long) o2.val;
                if (l == 0) {
                    return 0;
                } else if (l < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                long l = (long) list.get(i).val - (long) list.get(j).val;
                if (Math.abs(l) <= t) {
                    if (Math.abs(list.get(i).index - list.get(j).index) <= k) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k && (i + j) < nums.length; j++) {
                if (compare(nums[i + j] - nums[i], j, k, t)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean compare(int v, int i, int k, int t) {
        if(v < 0) {
//            v = ^v + 1;
        }
        if(v <= t && i <= k) {
            return true;
        }
        return false;
    }

}
