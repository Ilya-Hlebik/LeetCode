package LeetCode75.Chapter_5_HashMap_Set.lc_03_1657_Determine_if_Two_Strings_Are_Close;

import java.util.*;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        Set<Character> characters = map1.keySet();
        Set<Character> characters1 = map2.keySet();
        if (!characters.equals(characters1)){
            return false;
        }
        List<Integer> values = new ArrayList<>( map1.values());
        Collections.sort(values);
        List<Integer> values1 = new ArrayList<>(  map2.values());
        Collections.sort(values1);
        return values.equals(values1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("abc", "bca"));
    }
}
