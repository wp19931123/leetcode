package cn.leetcode.middle;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * 示例:
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 */
public class ComputeArea {

    //一个矩形在另一个的上下左右四个位置不重叠，这四种情况下返回两个矩形面积之和。
    //其他所有情况下两个矩形是有交集的
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A)*(D-B) + (G-E)*(H-F);
        if(E >= C || F >= D || B >= H || G <= A) {
            return sum;
        }
        //重叠区域的矩形面积
        int s = (Math.min(C,G)- Math.max(A,E)) * (Math.min(D,H) - Math.max(B,F));
        return sum-s;
    }
}
