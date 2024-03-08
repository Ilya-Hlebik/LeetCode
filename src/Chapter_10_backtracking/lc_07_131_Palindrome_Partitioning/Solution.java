package Chapter_10_backtracking.lc_07_131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.equals("")) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                List<List<String>> partition = partition(s.substring(i + 1));
                for (List<String> list : partition) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int n) {
        if (n < 2) {
            return true;
        }
        StringBuilder builder = new StringBuilder(s.substring(0, n));
        return builder.toString().equals(builder.reverse().toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("abbab"));
    }
}
