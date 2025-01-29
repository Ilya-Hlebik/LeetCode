package Top100Liked.Chapter_4_Dynamic_Programming.lc_07_139_Word_Break;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, wordDict, new HashMap<>());
    }

    public boolean dfs(String s, int index, List<String> wordDict, Map<Map.Entry<Integer, String>, Boolean> memo) {
        if (index == s.length()) {
            return true;
        }
        char[] chars = s.toCharArray();
        for (String word : wordDict) {
            if (startWith(chars, index, word)) {
                Map.Entry<Integer, String> entry = Map.entry(index, word);
                if (!memo.containsKey(entry)) {
                    boolean dfs = dfs(s, index + word.length(), wordDict, memo);
                    memo.put(entry, dfs);
                }
                if (memo.get(entry)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean startWith(char[] s, int index, String word) {
        if (index + word.length() > s.length) {
            return false;
        }
        for (int i = index, j = 0; i < s.length && j<word.length(); i++, j++) {
            if (s[i] != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
