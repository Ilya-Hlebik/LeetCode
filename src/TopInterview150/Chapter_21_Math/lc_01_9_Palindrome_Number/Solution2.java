package TopInterview150.Chapter_21_Math.lc_01_9_Palindrome_Number;

public class Solution2 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
