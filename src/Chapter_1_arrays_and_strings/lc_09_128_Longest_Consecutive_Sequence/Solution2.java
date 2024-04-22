package Chapter_1_arrays_and_strings.lc_09_128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestConsecutive(new int[]{1, 0, -1}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = 1;
                while (set.contains(++num)) {
                    current++;
                }
                longest = Math.max(longest, current);
                if (longest > nums.length / 2) {
                    break;
                }
            }
        }
        return longest;
    }
}
