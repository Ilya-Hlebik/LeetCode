package Chapter_2_two_pointers.lc_01_125_Valid_Palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder alphaNumeric = new StringBuilder();
        for (char letter: chars){
            if (Character.isLetterOrDigit(letter)){
                alphaNumeric.append(letter);
            }
        }
        return alphaNumeric.toString().equals(alphaNumeric.reverse().toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
    }
}
