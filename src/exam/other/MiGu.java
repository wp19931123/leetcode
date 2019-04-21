package exam.other;

import java.util.ArrayList;
import java.util.Scanner;

public class MiGu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] matrix = new int[m][n];
        while(sc.hasNext()) {
            for(int i = 0; i < m;i++) {
                for(int j = 0;j < n;j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        }

        ArrayList<Integer> res = new MiGu().printMatrix(matrix);
        for(int i : res) {
            System.out.println(i);
        }
        sc.close();

    }
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            if(matrix == null) {
                return null;
            }
            int row = matrix.length;
            int colum = matrix[0].length;
            ArrayList<Integer> list = new ArrayList<Integer>();
            int n = 0; //打印第几圈，从0开始
            while(row > 2*n && colum > 2*n) {
                list.addAll(printCircle(matrix,row,colum,n++));
            }
            return list;
        }
        public ArrayList<Integer> printCircle(int[][] matrix, int row, int colum, int n) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = n; i < colum - n ; i++) {
                list.add(matrix[n][i]);
            }
            if(row - 2*n > 1) {
                for(int i = n + 1; i < row - n; i++) {
                    list.add(matrix[i][colum - 1 - n]);
                }
            }
            if(row - 2*n > 1 && colum - 2* n > 1) {
                for(int i = colum - 2 - n;i >= n; i--) {
                    list.add(matrix[row - 1 - n][i]);
                }
            }
            if(row - 2*n > 2 && colum - 2*n > 1) {
                for(int i = row - 2 - n; i >= n + 1; i-- ) {
                    list.add(matrix[i][n]);
                }
            }
            return list;
        }

}
