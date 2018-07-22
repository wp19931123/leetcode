package cn.leetcode.middle;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 */
public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.print(new NumIslands().numIslands(grid));
    }

    /**
     * 我们现在把目光聚焦到其中一个1上，从这个1开始，先将这个1改成0，再沿着上下左右4个方向开始遍历矩阵，
     * 遍历的方法是深度优先搜索，将所有遍历到的1都改成0，直到在一个1的四个方向上相邻的的元素都是0，
     * 那么停止对这个元素的深搜。这样，我们就将“一个岛屿”上的所有1都改成了0，从地图上看，这个岛屿“消失了”。
     * 那么有多少个岛屿呢？就看这样的深搜遍历有多少次（因为一次这样的深搜消去了一个岛屿）
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {  //注意字符'0'和0
                    continue;
                }
                res++;
                dfs(grid, i, j);
            }
        }

        return res;
    }

    //一次深搜，讲这个1周围的1全部置0，消灭了一个岛屿
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
