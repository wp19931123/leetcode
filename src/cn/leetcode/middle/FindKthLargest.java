package cn.leetcode.middle;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.print(new FindKthLargest().findKthLargest(arr, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length || k < 1) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        if (k > nums.length || k < 1) {
            return Integer.MIN_VALUE;
        }
        int[] minHeap = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            minHeap[i] = nums[i - 1];
            adjustHeap(minHeap, i);
        }

        for (int i = k + 1; i <= nums.length; i++) {
            int cur = nums[i - 1];
            if (cur > minHeap[1]) {
                minHeap[1] = cur;
                adjustHeapAtHead(minHeap);
            }
        }

        return minHeap[1];
    }

    private void adjustHeap(int[] arr, int index) {
        while (index > 1) {
            if (arr[index] < arr[index / 2]) {
                swap(arr, index, index / 2);
            } else {
                break;
            }
            index /= 2;
        }
    }

    private void adjustHeapAtHead(int[] arr) {
        int index = 1, tmp;
        while (index <= arr.length - 1) {
            if (index * 2 >= arr.length - 1) {
                if (index * 2 == arr.length - 1 && arr[index] > arr[index * 2]) {
                    swap(arr, index, index * 2);
                }
                break;
            } else {
                tmp = arr[index * 2] < arr[index * 2 + 1] ? index * 2 : index * 2 + 1;
                if (arr[tmp] > arr[index]) break;
                swap(arr, index, tmp);
                index = tmp;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
