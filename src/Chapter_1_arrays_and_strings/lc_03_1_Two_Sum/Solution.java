package Chapter_1_arrays_and_strings.lc_03_1_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return null;
    }
}
