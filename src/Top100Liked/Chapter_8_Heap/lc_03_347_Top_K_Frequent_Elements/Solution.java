package Top100Liked.Chapter_8_Heap.lc_03_347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.forEach((key, val) -> queue.add(new int[]{key, val}));
        int[] res = new int[k];
        for (int i = 0; !queue.isEmpty() && i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
