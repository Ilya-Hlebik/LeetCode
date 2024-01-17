package arrays_and_strings.lc_05_347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .limit(k).map(Map.Entry::getKey)
                .mapToInt(value -> value).toArray();
    }
}
