package Top100Liked.Chapter_11_Sliding_Window.lc_02_76._Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            int left = 0;
            int match = 0;
            int size = Integer.MAX_VALUE;
            int finalStart = 0;
            int finalEnd = 0;
            for (int right = 0; right < s.length(); right++) {
                char letter = s.charAt(right);
                if (map.containsKey(letter)) {
                    int value = map.get(letter) - 1;
                    map.put(letter, value);
                    if (value == 0) {
                        match++;
                    }
                }
                while (map.size() == match) {
                    if (right - left < size) {
                        finalStart = left;
                        finalEnd = right;
                        size = right - left;
                    }
                    char leftLetter = s.charAt(left++);
                    if (map.containsKey(leftLetter)) {
                        int value = map.get(leftLetter) + 1;
                        map.put(leftLetter, value);
                        if (value > 0) {
                            match--;
                        }
                    }
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(finalStart, finalEnd + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minWindow("ADOBECODEBANC","ABC");
    }
}
