package Interview_prepare.newrub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : p.toCharArray()) {
            map1[c - 'a']++;
        }
        int l = 0;
        int r = 0;
        List<Integer> result = new ArrayList<>();
        while (r < s.length()) {
            map2[s.charAt(r) - 'a']++;
            if (r >= p.length() - 1) {
                if (Arrays.equals(map1, map2)) {
                    result.add(l);
                }
                map2[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.findAnagrams("cbaebabacd", "abc"));
    }
}
