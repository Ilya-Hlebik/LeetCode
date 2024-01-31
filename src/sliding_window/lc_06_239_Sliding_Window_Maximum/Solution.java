package sliding_window.lc_06_239_Sliding_Window_Maximum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[resultIndex++] = map.keySet().iterator().next();
        for (int left = 0, right = k; right < nums.length; right++, left++) {
            Integer integer = map.get(nums[left]);
            if (integer == 1) {
                map.remove(nums[left]);
            } else {
                map.put(nums[left], integer - 1);
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            result[resultIndex++] = map.keySet().iterator().next();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
