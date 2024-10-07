package TopInterview150.Chapter_21_Math.lc_01_9_Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        String val = String.valueOf(x);
        return val.equals(new StringBuilder(val).reverse().toString());
    }
}
