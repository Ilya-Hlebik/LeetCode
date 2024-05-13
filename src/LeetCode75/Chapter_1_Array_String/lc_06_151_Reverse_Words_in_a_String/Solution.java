package LeetCode75.Chapter_1_Array_String.lc_06_151_Reverse_Words_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && word.length() != 0) {
                words.add(word.toString());
                word = new StringBuilder();
            } else if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            }
        }
        if (word.length() != 0){
            words.add(word.toString());
        }
        StringBuilder result = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i)).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
