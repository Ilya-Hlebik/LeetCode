package freeRun.lc_51_229_Majority_Element_2;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int requiredCount = nums.length / 3;
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
            if (value > requiredCount) {
                result.add(num);
            }
        }
        return new ArrayList<>(result);
    }
}
