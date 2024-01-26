package sliding_window.lc_03_424_Longest_Repeating_Character_Replacement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int max = 0;
        HashMap<Character, Integer> lettersToLettersCount = new HashMap<>();
        while (j < s.length()) {
            char charAtJ = s.charAt(j);
            Integer orDefault = lettersToLettersCount.getOrDefault(charAtJ, 0);
            int newValue = orDefault + 1;
            lettersToLettersCount.put(charAtJ, newValue);
            Map.Entry<Character, Integer> characterIntegerEntry = lettersToLettersCount.entrySet()
                    .stream().max(Map.Entry.comparingByValue())
                    .orElse(null);
            Integer count = Optional.ofNullable(characterIntegerEntry).map(Map.Entry::getValue).orElse(0);
            if (j - i + 1 - count <= k) {
                max = Math.max(max, j - i + 1);
            } else {
                char oldChar = s.charAt(i);
                Integer oldCharCount = lettersToLettersCount.get(oldChar);
                lettersToLettersCount.put(oldChar, oldCharCount - 1);
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }
}
