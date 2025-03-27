package Top100Liked.Chapter_11_Sliding_Window.lc_01_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            while (set.contains(current)) {
                set.remove(s.charAt(l++));
            }
            set.add(current);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
