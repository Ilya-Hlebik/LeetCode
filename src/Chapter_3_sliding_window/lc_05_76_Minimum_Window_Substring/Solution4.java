package Chapter_3_sliding_window.lc_05_76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int finalStart = 0;
        int finalEnd = 0;
        int matched = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) {
                    matched++;
                }
            }
            while (matched == map.size()) {
                if (size > end - start) {
                    size = end - start;
                    finalStart = start;
                    finalEnd = end;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) {
                        matched--;
                    }
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return size <= s.length() ? s.substring(finalStart, finalEnd + 1) : "";
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
        System.out.println(solution.minWindow("a", "b"));
        System.out.println(solution.minWindow("ab", "a"));
        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
