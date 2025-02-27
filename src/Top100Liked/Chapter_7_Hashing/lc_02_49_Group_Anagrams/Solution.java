package Top100Liked.Chapter_7_Hashing.lc_02_49_Group_Anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
