package cn.leetcode.middle;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/**
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。
 * 设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 */
public class PeekingIterator implements Iterator<Integer> {

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {


        return 0;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {


        return 0;
    }

    @Override
    public boolean hasNext() {


        return false;
    }
}
