package cn.leetcode.middle;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchMatrix {

    //时间复杂度：O(row+log(colum))
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int colum = matrix[0].length;
        //搜索第一列
        if(matrix[0][0] > target) {
            return false;
        }
        int R = 0;
        for(int i = 1;i < row;i++) {
            if(matrix[i][0] == target) {
                return true;
            }else if(matrix[i][0] < target) {
                R++;
            }else{
                break;
            }
        }
        //二分查找
        return binSearch(matrix[R],0,colum-1,target);

    }
    public boolean binSearch(int[] arr, int begin,int end,int target) {
        while( begin <= end) {
            int mid = begin + (end-begin)/2;
            if(arr[mid] == target) {
                return true;
            }else if(arr[mid] < target) {
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
