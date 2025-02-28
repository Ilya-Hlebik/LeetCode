package Top100Liked.Chapter_7_Hashing.lc_03_128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int temp = num;
                int count = 0;
                while (set.contains(temp++)) {
                    count++;
                }
                max = Math.max(count, max);
                if (max>nums.length/2){
                    break;
                }
            }
        }
        return max;
    }
}
