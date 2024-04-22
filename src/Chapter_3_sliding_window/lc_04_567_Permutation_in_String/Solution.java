package Chapter_3_sliding_window.lc_04_567_Permutation_in_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] charsS1 = s1.toCharArray();
        for (int i = 0, j = s1.length(); j <= s2.length(); j++, i++) {
            char[] charsS2 = s2.substring(i, j).toCharArray();
            if (arraysEqualsIgnoreOrder(charsS1, charsS2)) {
                return true;
            }
        }
        return false;
    }

    private boolean arraysEqualsIgnoreOrder(char[] charsS1, char[] charsS2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charsS1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : charsS2) {
            Integer integer = map.get(c);
            if (integer != null) {
                map.put(c, integer - 1);
            } else {
                return false;
            }
        }
        return map.values().stream().allMatch(integer -> integer == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
        System.out.println(solution.checkInclusion("hello", "ooolleoooleh"));
    }
}
