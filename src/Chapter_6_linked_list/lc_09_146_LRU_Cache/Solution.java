package Chapter_6_linked_list.lc_09_146_LRU_Cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
    LinkedHashMap<Integer, Integer> mapLinked = new LinkedHashMap<>();
    LinkedList<Integer> list = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
        } else if (capacity == list.size()) {
            Integer keyToRemove = list.removeFirst();
            map.remove(keyToRemove);
        }
        list.add(key);
        map.put(key, value);
    }
}
