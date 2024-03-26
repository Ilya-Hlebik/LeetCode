package Chapter_12_advanced_graphs.lc_05_Alien_Dictionary;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    Map<Character, Set<Character>> adj = new HashMap<>();

    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> visit = new HashMap<>();
        List<Character> res = new ArrayList<>();
        for (Character character : adj.keySet()) {
            if (dfs(character, visit, res)) {
                return "";
            }
        }
        Collections.reverse(res);
        return res.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private boolean dfs(Character c, Map<Character, Boolean> visit, List<Character> res) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }
        visit.put(c, true);
        Set<Character> characters = adj.get(c);
        for (Character character : characters) {
            if (dfs(character, visit, res)) {
                return true;
            }
        }
        visit.put(c, false);
        res.add(c);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.foreignDictionary(new String[]{"hrn", "hrf", "er", "enn", "rfnn"}));
    }

}
