package cn.leetcode.middle;
/**
 * 生命游戏:
 * 活细胞 <2或者>3  -> 死亡
 * 死细胞 3        -> 复活
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 进阶:
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new GameOfLife().gameOfLife(board);
        for(int[] arr : board) {
            for(int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length,colum = board[0].length;
        int[][] help = new int[row][colum];
        for(int i = 0;i < row;i++) {
            for (int j = 0; j < colum; j++) {
                help[i][j] = board[i][j];
            }
        }
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < colum;j++) {
                if(help[i][j] == 1) {
                    if(aroundLive(help,row,colum,i,j) < 2 || aroundLive(help,row,colum,i,j) > 3) {
                        board[i][j] = 0;
                    }
                }else{
                    if(aroundLive(help,row,colum,i,j) == 3) {
                        board[i][j] = 1;
                    }
                }

            }
        }
    }

    private int aroundLive(int[][] board, int row, int colum, int i, int j) {
        int count = 0;
        if(Isvalid(board,row,colum,i-1,j-1) && board[i-1][j-1] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i-1,j) && board[i-1][j] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i-1,j+1) && board[i-1][j+1] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i,j-1) && board[i][j-1] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i,j+1) && board[i][j+1] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i+1,j-1) && board[i+1][j-1] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i+1,j) && board[i+1][j] == 1) {
            count++;
        }
        if(Isvalid(board,row,colum,i+1,j+1) && board[i+1][j+1] == 1) {
            count++;
        }
        return count;
    }

    private boolean Isvalid(int[][] board, int row, int colum, int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < colum;
    }


}
