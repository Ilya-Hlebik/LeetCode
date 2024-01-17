package arrays_and_strings.lc_04_49_Group_Anagrams;

import java.util.*;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
            list.add(word);
            map.put(sortedWord, list);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.groupAnagrams(new String[]{"ate", "eat", "tea"}));
        System.out.println(solution.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}
