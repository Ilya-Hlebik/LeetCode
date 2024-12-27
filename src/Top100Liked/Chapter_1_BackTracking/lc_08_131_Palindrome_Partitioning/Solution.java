package Top100Liked.Chapter_1_BackTracking.lc_08_131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, List<String> temp, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < s.length(); i++) {
            if (palindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                dfs(s, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean palindrome(String s, int start, int i) {
        while (start < i) {
            if (s.charAt(start++) != s.charAt(i--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
    }
}
