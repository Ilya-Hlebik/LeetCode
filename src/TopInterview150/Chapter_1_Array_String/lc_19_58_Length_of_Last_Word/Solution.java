package TopInterview150.Chapter_1_Array_String.lc_19_58_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        int length =0;
        s = s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                break;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLastWord("   fly me   to   the moon  ");
    }
}
