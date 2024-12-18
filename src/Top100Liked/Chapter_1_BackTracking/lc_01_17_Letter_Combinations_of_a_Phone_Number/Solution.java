package Top100Liked.Chapter_1_BackTracking.lc_01_17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, List<Character>> map = new HashMap<>();

    {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(result, "", digits, 0);
        return result;
    }

    public void dfs(List<String> result, String temp, String digits, int index) {
        if (index == digits.length()) {
            if (!temp.isEmpty()) {
                result.add(temp);
            }
            return;
        }
        List<Character> list = map.get(digits.charAt(index));
        for (Character character : list) {
            dfs(result, temp + character, digits, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
