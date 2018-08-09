package cn.leetcode.middle;

import java.util.*;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
 * 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表
 */
public class FindMinHeightTrees {

    /**
     * 建立一个图g，是一个二维数组，其中g[i]是一个一维数组，保存了i节点可以到达的所有节点。
     * 我们开始将所有只有一个连接边的节点(叶节点)都存入到一个队列queue中，然后我们遍历每一个叶节点，
     * 通过图来找到和其相连的节点，并且在其相连节点的集合中将该叶节点删去，如果删完后此节点也也变成一个叶节点了，
     * 加入队列中，再下一轮删除。那么我们删到什么时候呢，当节点数小于等于2时候停止，
     * 此时剩下的一个或两个节点就是我们要求的最小高度树的根节点
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
