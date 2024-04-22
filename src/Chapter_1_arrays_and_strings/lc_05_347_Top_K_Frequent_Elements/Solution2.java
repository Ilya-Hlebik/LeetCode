package Chapter_1_arrays_and_strings.lc_05_347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());
        int i = 0;
        while (i !=k) {
            arr[i++] = pq.poll().getKey();
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
