package cn.leetcode.middle;

/**
 * 807. 保持城市天际线
 */
public class MaxIncreaseKeepingSkyline {

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        //从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
        //从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
        System.out.println(new MaxIncreaseKeepingSkyline().maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] col = new int[grid[0].length];
        int[] row = new int[grid.length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] = Math.max(grid[i][j], row[i]); //每一行的最大值
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                col[i] = Math.max(grid[j][i], col[i]);  //每一列的最大值
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int small = Math.min(row[i],col[j]);
                if(grid[i][j] < small) {
                    res += small - grid[i][j];
                }
            }
        }
        return res;
    }
}
