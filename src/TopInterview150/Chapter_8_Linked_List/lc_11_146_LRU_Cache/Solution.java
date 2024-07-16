package TopInterview150.Chapter_8_Linked_List.lc_11_146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
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

    private void remove(Node node) {
        if (node == null) {
            return;
        }
        if (node == head) {
            head = node.next;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        insert(map.get(key));
        if (capacity < map.size()) {
            int tailKey = tail.key;
            remove(map.get(tailKey));
            map.remove(tailKey);
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
