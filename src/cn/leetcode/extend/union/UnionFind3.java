package cn.leetcode.extend.union;

public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];  //表示节点的数量
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;  //节点个数初始为1
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = parent[pRoot];
            sz[pRoot] += sz[qRoot];
        }
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new RuntimeException("error");
        }
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
}
