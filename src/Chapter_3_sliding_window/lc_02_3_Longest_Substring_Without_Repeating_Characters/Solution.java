package Chapter_3_sliding_window.lc_02_3_Longest_Substring_Without_Repeating_Characters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder longest = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            while (longest.toString().contains(letter)) {
                longest.deleteCharAt(0);
            }
            longest.append(letter);
            max = Math.max(max, longest.length());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
