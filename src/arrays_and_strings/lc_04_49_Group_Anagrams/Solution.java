package arrays_and_strings.lc_04_49_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < word.length(); i++) {
                arr[word.charAt(i) - 'a']++;
            }
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"ate", "eat", "tea"}));
        System.out.println(solution.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}
