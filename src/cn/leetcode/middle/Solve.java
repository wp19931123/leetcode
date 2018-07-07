package cn.leetcode.middle;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solve {

    //回溯法，以四周的节点为起点，向周围扩散，遇到O则将其改编为+，
    // 当四周节点都便利完成后，将所有O都替换为X，再将所有+替换回O
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }

        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == '+') {
                    board[i][j] = 'O';
                }

            }
        }

    }

    private void dfs(char[][] board, int row, int colum) {
        if (row < 0 || row >= board.length || colum < 0 || colum >= board[0].length) {
            return;
        }
        if (board[row][colum] != 'O') {
            return;
        }
        board[row][colum] = '+';
        dfs(board, row - 1, colum);
        dfs(board, row + 1, colum);
        dfs(board, row, colum - 1);
        dfs(board, row, colum + 1);
    }
}
