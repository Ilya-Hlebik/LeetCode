package Chapter_6_linked_list.lc_09_146_LRU_Cache.sol2;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(key);
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));

        if (capacity < map.size()) {
            int tailKey = tail.key;
            remove(tailKey);
            map.remove(tailKey);
        }
    }

    private void insert(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
            head.prev = null;
        }
    }

    private void remove(int key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }
}

class Node {
    public Node next;
    public Node prev;
    public int value;
    public int key;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
