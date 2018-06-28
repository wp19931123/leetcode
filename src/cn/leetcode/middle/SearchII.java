package cn.leetcode.middle;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2]
 */
public class SearchII {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(new SearchII().search(arr, 3));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        return search(nums,target,l,r);
    }

    public boolean search(int[] A, int target, int l, int r) {
        if (l > r) {
            return false;
        }
        while (l < r && A[l] == A[r]) {
            l++;
        }
        int mid = (l + r) / 2;
        if (A[mid] == target) {
            return true;
        }
        if (A[mid] >= A[l]) {
            if (A[mid] >= target && A[l] <= target) {
                return search(A, target, l, mid - 1);
            } else {
                return search(A, target, mid + 1, r);
            }
        } else {
            if (A[mid] <= target && A[r] >= target) {
                return search(A, target, mid + 1, r);
            } else {
                return search(A, target, l, mid - 1);
            }
        }
    }
}
