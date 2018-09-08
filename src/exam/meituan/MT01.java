package exam.meituan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MT01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        //遍历完所有的节点
        MT01 mt = new MT01();
        System.out.println(mt.shortestPathLength(matrix));
        //输出总路径最小值
    }

    public int shortestPathLength(int[][] graph) {
        int kAns = (1 << graph.length) - 1;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[graph.length][1 << graph.length];
        for (int i = 0; i < graph.length; i++)
            q.offer(new Pair(i, 1 << i));

        int steps = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                Pair pair = q.poll();
                int n = pair.i;
                int state = pair.j;
                if (state == kAns)
                    return steps;
                if (visited[n][state] == 1)
                    continue;
                visited[n][state] = 1;
                for (int next : graph[n])
                    q.offer(new Pair(next, state | (1 << next)));
            }
            steps++;
        }
        return -1;
    }

    class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
