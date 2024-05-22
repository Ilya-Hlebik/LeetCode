package LeetCode75.Chapter_16_Backtracking.lc_01_17_Letter_Combinations_of_a_Phone_Number;

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
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> resultList = new ArrayList<>();
        dfs(chars, 0, "", resultList);

        return resultList;
    }

    private void dfs(char[] chars, int i, String result, List<String> resultList) {
        if (i > chars.length - 1) {
            resultList.add(result);
            return;
        }
        List<Character> list = map.get(Character.digit(chars[i], 10));
        for (Character character : list) {
            dfs(chars, i + 1, result + character, resultList);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}
