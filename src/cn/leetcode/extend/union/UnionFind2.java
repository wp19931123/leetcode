package cn.leetcode.extend.union;

public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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
    public void unionElements(int p, int q) {  //时间复杂度O(h) 树的高度
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
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
