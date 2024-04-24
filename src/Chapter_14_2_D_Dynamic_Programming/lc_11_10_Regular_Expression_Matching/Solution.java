package Chapter_14_2_D_Dynamic_Programming.lc_11_10_Regular_Expression_Matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, cache);
    }

    private boolean dfs(String s, String p, int i, int j, Boolean[][] cache) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        if (i >= s.length() && j >= p.length()) {
            cache[i][j] = true;
            return true;
        }
        if (j >= p.length()) {
            cache[i][j] = false;
            return false;
        }
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 <= p.length() - 1 && p.charAt(j + 1) == '*') {
            cache[i][j] = dfs(s, p, i, j + 2, cache) || (match && dfs(s, p, i + 1, j, cache));
            return cache[i][j];
        }
        if (match) {
            cache[i][j] = dfs(s, p, i + 1, j + 1, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a*"));
    }
}
