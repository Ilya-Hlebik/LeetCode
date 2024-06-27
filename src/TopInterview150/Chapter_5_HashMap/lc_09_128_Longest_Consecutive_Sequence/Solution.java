package TopInterview150.Chapter_5_HashMap.lc_09_128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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
                longest = Math.max(current, longest);
                if (longest > nums.length / 2) {
                    break;
                }
            }
        }
        return longest;
    }
}
