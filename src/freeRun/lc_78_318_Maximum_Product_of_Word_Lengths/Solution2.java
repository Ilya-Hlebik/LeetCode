package freeRun.lc_78_318_Maximum_Product_of_Word_Lengths;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    Map<String, int[]> memo = new HashMap<>();

    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << c);
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
    }

}
