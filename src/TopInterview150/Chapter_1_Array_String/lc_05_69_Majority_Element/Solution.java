package TopInterview150.Chapter_1_Array_String.lc_05_69_Majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
            if (value > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
}
