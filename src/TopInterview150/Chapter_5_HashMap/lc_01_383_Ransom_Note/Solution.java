package TopInterview150.Chapter_5_HashMap.lc_01_383_Ransom_Note;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false;
            }
            Integer currentValue = magazineMap.get(c);
            magazineMap.put(c, currentValue - 1);
        }
        return true;
    }
}
