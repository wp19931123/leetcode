package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。在选修某些课程之前需要一些先修课程。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序,拓扑排序也可以通过 BFS 完成。
 */
public class CanFinish {

    //广度优先搜索。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        List<Integer>[] satisfies = new List[numCourses];
        for (int i = 0; i < numCourses; i++) satisfies[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            satisfies[prerequisites[i][1]].add(prerequisites[i][0]);
            pre[prerequisites[i][0]]++;
        }
        int finish = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.remove();
            finish++;
            if (satisfies[course] == null) continue;
            for (int c : satisfies[course]) {
                pre[c]--;
                if (pre[c] == 0) queue.add(c);
            }
        }
        return finish == numCourses;
    }

    private boolean[] canFinish;
    private boolean[] visited;
    private List<Integer>[] depends;

    //深度优先搜索。
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        canFinish = new boolean[numCourses];
        visited = new boolean[numCourses];
        depends = new List[numCourses];
        for (int i = 0; i < numCourses; i++) depends[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            depends[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i)) return false;
        }
        return true;
    }

    private boolean canFinish(int course) {
        if (visited[course]) return canFinish[course];
        visited[course] = true;
        for (int c : depends[course]) {
            if (!canFinish(c)) return false;
        }
        canFinish[course] = true;
        return canFinish[course];
    }


}
