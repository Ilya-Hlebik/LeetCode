package TopInterview150.Chapter_5_HashMap.lc_02_205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        StringBuilder afterReplace = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            }
            afterReplace.append(map.get(s.charAt(i)));
        }
        return afterReplace.toString().equals(t);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isIsomorphic("badc", "baba");
    }
}
