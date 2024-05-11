package LeetCode75.Chapter_1_Array_String.lc_05_345_Reverse_Vowels_of_a_String;

import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        char[] temp = s.toLowerCase().toCharArray();
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (vowels.contains(temp[i])) {
                builder.append(chars[i]);
                chars[i] = '_';
            }
        }
        String reversedVowels = builder.reverse().toString();
        for (int i =0, j=0; i< chars.length; i++){
            if (chars[i] == '_'){
                chars[i] = reversedVowels.charAt(j);
                j++;
            }
        }
        return new String(chars);
    }
}
