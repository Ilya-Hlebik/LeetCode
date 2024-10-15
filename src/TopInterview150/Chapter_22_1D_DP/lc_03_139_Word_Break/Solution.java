package TopInterview150.Chapter_22_1D_DP.lc_03_139_Word_Break;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("applepenapple", List.of("apple", "pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, "", wordDict, new HashMap<>());
    }

    public boolean wordBreakHelper(String s, String temp, List<String> wordDict, Map<String, Boolean> memo) {
        if (!s.startsWith(temp)) {
            return false;
        }
        if (s.equals(temp)) {
            return true;
        }
        if (memo.containsKey(temp)){
            return memo.get(temp);
        }
        for (String s1 : wordDict) {
            boolean isPossible = wordBreakHelper(s, temp + s1, wordDict, memo);
            memo.put(temp+s1, isPossible);
            if (isPossible){
                 return true;
             }
        }
        return false;
    }
}
