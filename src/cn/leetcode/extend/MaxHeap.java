package cn.leetcode.extend;

public class MaxHeap {

    private int[] heap;
    private int currentSize;
    private static int MAXSIZE;

    public MaxHeap(int n) {
        heap = new int[n];
        currentSize = 0;
        MAXSIZE = n;
    }

    public boolean insert(int x) {
        if (currentSize == MAXSIZE) {
            System.out.println("Sorry,this heap is full!");
            return false;
        }
        //如果堆不满的话
        currentSize++;
        int flag = currentSize - 1;
        while (flag > 0) {
            int parent = (flag - 1) / 2;
            if (heap[parent] > x) {
                heap[flag] = x;
                return true;
            } else {
                heap[flag] = heap[parent];
                flag = parent;
            }
        }
        heap[0] = x;
        return true;
    }

    public void siftDown(int flag) {
        int want = flag;
        int x = heap[flag];

        while (want < currentSize) {
            int lChild = 2 * want + 1;
            int rChild = 2 * want + 2;
            int MAXChildNumber;
            if (lChild > currentSize) {  //没有孩子节点
                heap[want] = x;
            } else {                   //有两个孩子节点
                if (lChild < currentSize) {
                    MAXChildNumber = heap[lChild] > heap[rChild] ? lChild : rChild;
                } else {
                    MAXChildNumber = lChild;
                }
                if (heap[MAXChildNumber] < x) {
                    heap[want] = x;
                    return;
                } else {
                    heap[want] = heap[MAXChildNumber];
                    want = MAXChildNumber;
                }
            }
        }

    }

    public int deleteTop() {
        if (currentSize < 0) {
            System.out.println("Sorry, this heap is empty!");
            return -1;
        }
        int target = heap[0];
        int substitute = heap[currentSize - 1];
        this.currentSize--;
        heap[0] = substitute;
        siftDown(0);
        return target;
    }

}
