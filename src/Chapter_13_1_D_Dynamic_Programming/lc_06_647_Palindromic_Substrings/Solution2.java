package Chapter_13_1_D_Dynamic_Programming.lc_06_647_Palindromic_Substrings;

public class Solution2 {
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
                result++;
            }
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
                result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.countSubstrings("abbaa"));
    }
}
