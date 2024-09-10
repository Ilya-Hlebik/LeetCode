package TopInterview150.Chapter_15_BackTracking.lc_01_17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, List<Character>> map = new HashMap<>();

    {
        map.put(1, new ArrayList<>());
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            dfs(new StringBuilder(), 0, digits, result);
        }
        return result;
    }

    public void dfs(StringBuilder current, int index, String digits, List<String> result) {
        if (index > digits.length() - 1) {
            result.add(current.toString());
            return;
        }
        int digit = Character.digit(digits.charAt(index), 10);
        for (Character character : map.get(digit)) {
            current.append(character);
            dfs(current, index + 1, digits, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }
}
