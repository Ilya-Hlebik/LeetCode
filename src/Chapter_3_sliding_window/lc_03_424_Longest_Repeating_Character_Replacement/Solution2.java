package Chapter_3_sliding_window.lc_03_424_Longest_Repeating_Character_Replacement;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
   //     System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int i = 0;
        int max = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            int letter = s.charAt(j) - 'A';
            arr[letter]++;
            max = Math.max(max, arr[letter]);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
