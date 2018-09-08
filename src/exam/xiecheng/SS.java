package exam.xiecheng;

import java.util.*;

//设计可以变更的缓存结构

//最近最少使用算法

public class SS {

    public static class Node<V> {

        public V value;

        public Node<V> last;

        public Node<V> next;


        public Node(V value) {

            this.value = value;

        }

    }


    //手写的双向链表

    public static class NodeDoubleLinkedList<V> {

        private Node<V> head;

        private Node<V> tail;


        public NodeDoubleLinkedList() {

            this.head = null;

            this.tail = null;

        }


        public void addNode(Node<V> newNode) {

            if (newNode == null) {

                return;

            }

            if (this.head == null) {

                this.head = newNode;

                this.tail = newNode;

            } else {

                this.tail.next = newNode;

                newNode.last = this.tail;

                this.tail = newNode;

            }

        }


        public void moveNodeToTail(Node<V> node) {

            if (this.tail == node) {

                return;

            }

            if (this.head == node) {

                this.head = node.next;

                this.head.last = null;

            } else {

                node.last.next = node.next;

                node.next.last = node.last;

            }

            node.last = this.tail;

            node.next = null;

            this.tail.next = node;

            this.tail = node;

        }


        public Node<V> removeHead() {

            if (this.head == null) {

                return null;

            }

            Node<V> res = this.head;

            if (this.head == this.tail) {

                this.head = null;

                this.tail = null;

            } else {

                this.head = res.next;

                res.next = null;

                this.head.last = null;

            }

            return res;

        }


    }

    //缓存的具体实现

    public static class MyCache<K, V> {

        private HashMap<K, Node<V>> keyNodeMap;

        private HashMap<Node<V>, K> nodeKeyMap;

        private NodeDoubleLinkedList<V> nodeList;

        private int capacity;


        public MyCache(int capacity) {

            if (capacity < 1) {

                throw new RuntimeException("should be more than 0.");

            }

            this.keyNodeMap = new HashMap<K, Node<V>>();

            this.nodeKeyMap = new HashMap<Node<V>, K>();

            this.nodeList = new NodeDoubleLinkedList<V>();

            this.capacity = capacity;

        }


//        public V get(K key) {
//
//            if (this.keyNodeMap.containsKey(key)) {
//
////                Node<V> result
    }
}