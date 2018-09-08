package exam.xiecheng;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class VV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.valueOf(sc.nextLine());
        LRUCache lru = new LRUCache(capacity);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            if (str[0].equals('p' + "")) {
                int key = Integer.valueOf(str[1]);
                int value = Integer.valueOf(str[2]);
                lru.put(key, value);
            } else {
                int key = Integer.valueOf(str[1]);
                int res = lru.get(key);
                System.out.println(res);
            }

        }
    }

    public static class LRUCache {
        private int capacity;
        private LinkedList<Integer> list;
        private HashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            list = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (list.size() == capacity) {
                    int last = list.removeLast();
                    map.remove(last);
                }
                list.addFirst(key);
                map.put(key, value);
            } else {
                map.put(key, value);
            }
        }
    }
}
