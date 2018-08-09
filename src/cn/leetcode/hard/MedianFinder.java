package cn.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
    }

    Queue<Integer> min = new PriorityQueue<>();
    Queue<Integer> max = new PriorityQueue<>((a,b) -> (b-a));

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(min.size() - max.size() == 1) {
            if(num > min.peek()) {
                Integer top = min.poll();
                max.offer(top);
                min.offer(num);
            }else{
                max.offer(num);
            }
        }else if(max.size() - min.size() == 1) {
            if(num < max.peek()) {
                Integer top = max.poll();
                max.offer(num);
                min.offer(top);
            }else{
                min.offer(num);
            }
        }else{
            if(min.isEmpty() || num > min.peek()) {
                min.offer(num);
            }else{
                max.offer(num);
            }
        }
    }

    public double findMedian() {
        if(length() % 2 == 1) {
            return min.size() > max.size() ? min.peek() : max.peek();
        }else{
            return (double)max.peek() + ((double)min.peek() - (double)max.peek())/2;
        }
    }

    public int length() {
        return min.size() + max.size();
    }
}
