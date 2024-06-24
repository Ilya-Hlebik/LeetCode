package TopInterview150.Chapter_5_HashMap.lc_03_290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0, j = 0; i < pattern.length(); i++, j++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(words[j])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[j]);
            } else if (map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(words[j])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordPattern("abba", "dog cat cat dog");
    }
}
