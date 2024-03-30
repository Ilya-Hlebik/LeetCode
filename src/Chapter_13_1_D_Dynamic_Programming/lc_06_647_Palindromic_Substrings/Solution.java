package Chapter_13_1_D_Dynamic_Programming.lc_06_647_Palindromic_Substrings;

public class Solution {
    public int countSubstrings(String s) {
        int  length = s.length();
        int count = s.length();
        while (length>1){
            for (int i = 0; i < s.length() && i + length -1 < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i+ length -1)){
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder(s.substring(i, i + length));
                if (stringBuilder.toString().equals(stringBuilder.reverse().toString())){
                    count++;
                }
            }
            length --;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countSubstrings("aaa");
    }
}
