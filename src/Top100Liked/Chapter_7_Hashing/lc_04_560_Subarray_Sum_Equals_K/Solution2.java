package Top100Liked.Chapter_7_Hashing.lc_04_560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.subarraySum(new int[]{1,2,3,1,3,2,1,-6,2}, 3);
    }
}
