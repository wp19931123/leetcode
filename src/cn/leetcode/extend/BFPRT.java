package cn.leetcode.extend;

import java.util.Arrays;

/**
 * 求无序数组的第k大/k小的数字，直接排序O(nlogn)
 * 也可以用堆来做O(n)
 */
public class BFPRT {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 6, 4, 2};
        System.out.println(getMinKthByBFPRT(arr, 4));
        printArr(arr);
//        printArr(getMinKNumByBFPRT(arr, 3));
    }

    public static int[] getMinKNumByBFPRT(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            return arr;
        }
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
        for (; index < res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

    public static int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = copyArray(arr);
        return bfprt(arr, 0, copyArr.length - 1, k - 1);
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //在begin和end范围内求第i小的数
    public static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedian(arr, begin, end); //求中位数的中位数
        int[] pivotRange = partition(arr, begin, end, pivot); //返回等于区域左边界和右边界
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur < big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        return new int[]{small + 1, big - 1};
    }

    private static int medianOfMedian(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(arr, 0, mArr.length - 1, mArr.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end) {
        if (begin == end) {
            return arr[begin];
        }
        Arrays.sort(arr, begin, end + 1);
        int mid = begin + (end - begin) / 2;
        return arr[mid];
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
