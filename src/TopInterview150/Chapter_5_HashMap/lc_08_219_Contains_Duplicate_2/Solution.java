package TopInterview150.Chapter_5_HashMap.lc_08_219_Contains_Duplicate_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Set<Integer> values = map.get(nums[i]);
                for (Integer value : values) {
                    if (Math.abs(value - i) <= k) {
                        return true;
                    }
                }
            }
            Set<Integer> orDefault = map.getOrDefault(nums[i], new HashSet<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
        return false;
    }
}
