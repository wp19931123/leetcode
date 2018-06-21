package cn.leetcode.easy;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        int[] res = new NextGreaterElement().nextGreaterElement(n1,n2);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i = 0;i < nums1.length;i++) {
            res[i] = -1;
        }
        for(int i = 0;i < nums1.length;i++) {
            for(int j = 0;j < nums2.length;j++) {
                if(nums2[j] == nums1[i]) {
                    for (int k = j+1;k < nums2.length;k++) {
                        if(nums2[k] > nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                }
            }

        }
        return res;
    }
}
