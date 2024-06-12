package TopInterview150.Chapter_2_Two_Pointers.lc_01_125_Valid_Palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char letter : chars) {
            if (Character.isLetterOrDigit(letter)) {
                builder.append(letter);
            }
        }
        return builder.toString().toLowerCase().equals(builder.reverse().toString().toLowerCase());
    }
}
