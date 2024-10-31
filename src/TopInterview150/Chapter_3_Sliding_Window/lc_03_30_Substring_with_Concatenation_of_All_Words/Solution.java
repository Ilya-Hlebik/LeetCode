package TopInterview150.Chapter_3_Sliding_Window.lc_03_30_Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words[0].length() * words.length > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int step = words[0].length();
        int windowSize = step * words.length;
        for (int i = 0; i <= s.length()-windowSize; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int l = i;
            int r = i + windowSize;
            while (l < r) {
                String word = s.substring(l, l+ step);
                if (counts.containsKey(word)) {
                    Integer currentCount = seen.getOrDefault(word, 0) +1;
                    seen.put(word, currentCount);
                    if (currentCount>counts.get(word)){
                        break;
                    }
                    l+=step;
                }
                else {
                    break;
                }

            }
            if (l==r){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
