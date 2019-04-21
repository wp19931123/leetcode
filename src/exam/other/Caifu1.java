package exam.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caifu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(",");
        int n = split.length;
        int ints[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.valueOf(split[j]);
            }
            if (i == n - 1) {
                break;
            } else {
                split = scanner.nextLine().split(",");
            }
        }
        List<Integer> list = new Caifu1().spiralOrder(ints);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + ",");
            } else {
                System.out.print(list.get(i));
            }

        }
        //System.out.println( new Caifu1().spiralOrder(ints));
        //System.out.println(Arrays.deepToString(ints));
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String[] strs = str1.split(" ");
//        int n = strs.length;
//        int[][] matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            matrix[0][i] = Integer.valueOf(strs[i]);
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        System.out.println(new Caifu1().spiralOrder(matrix));  //[1,2,3,4,8,12,11,10,9,5,6,7]
//        sc.close();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int row = matrix.length;
        if (row == 0) {
            return res;
        }
        int colum = matrix[0].length;
        if (row == 0 || colum == 0) {
            return res;
        }
        int n = 0;  //打印第几圈
        while (row > 2 * n && colum > 2 * n) {
            printCircle(matrix, row, colum, n++, res);
        }
        return res;
    }

    //打印一圈的函数  第n圈
    public List<Integer> printCircle(int[][] matrix, int row, int colum, int n, List<Integer> list) {

        for (int i = n; i < row - n; i++) {
            list.add(matrix[i][colum - n - 1]);
        }
        //剩余最少2列
        if (colum - 2 * n > 1) {
            for (int i = colum - n - 2; i >= n; i--) {
                list.add(matrix[row - n - 1][i]);
            }
        }
        //剩余最少2行2列
        if (row - 2 * n > 1 && colum - 2 * n > 1) {
            for (int i = row - n - 2; i >= n; i--) {
                list.add(matrix[i][n]);
            }
        }
        //剩余至少3行3列
        if (row - 2 * n > 2 && colum - 2 * n > 3) {
            for (int i = n + 1; i < colum - n - 1; i++) {
                list.add(matrix[n][i]);
            }
        }
        return list;
    }
}
