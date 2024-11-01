package TopInterview150.Chapter_3_Sliding_Window.lc_03_30_Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || s.length() < words[0].length() * words.length) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int match = 0;
            int left = i;
            int right = i;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordCount.containsKey(word)) {
                    match++;
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    int currentWordCount = wordCount.get(word);
                    while (seen.get(word) > currentWordCount) {
                        String leftWord = s.substring(left, left + wordLen);
                        match--;
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                    }
                    if (match == words.length) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    match = 0;
                    left = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(System.currentTimeMillis() - start);
    }
}
