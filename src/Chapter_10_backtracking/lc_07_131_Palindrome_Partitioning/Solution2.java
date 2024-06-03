package Chapter_10_backtracking.lc_07_131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, List<List<String>> result, List<String> tempList, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (palindrome(s, start, i)){
                tempList.add(s.substring(start, i + 1));
                dfs(s, result, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean palindrome(String s, int start, int i) {
        while (start< i){
            if (s.charAt(start++) != s.charAt(i--)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.partition("aab"));
    }
}
