package cn.leetcode.middle;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int index, String word) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        char ch = word.charAt(index);
        if(!visited[i][j] && board[i][j] == ch) {
            visited[i][j] = true;
            boolean res =  dfs(board,visited,i-1,j,index+1,word) || dfs(board,visited,i+1,j,index+1,word)
                    || dfs(board,visited,i,j-1,index+1,word) ||dfs(board,visited,i,j+1,index+1,word);
            visited[i][j] = false;
            return res;
        }

        return false;
    }
}
