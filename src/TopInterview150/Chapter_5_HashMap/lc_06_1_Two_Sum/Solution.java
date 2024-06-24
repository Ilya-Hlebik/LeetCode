package TopInterview150.Chapter_5_HashMap.lc_06_1_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numbers.containsKey(target - num)) {
                return new int[]{numbers.get(target - num), i};
            } else {
                numbers.put(num, i);
            }
        }
        return null;
    }
}
