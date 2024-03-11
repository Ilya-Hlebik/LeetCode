package Chapter_10_backtracking.lc_08_17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> numbers = new HashMap<>();

    {
        numbers.put('2', "abc");
        numbers.put('3', "def");
        numbers.put('4', "ghi");
        numbers.put('5', "jkl");
        numbers.put('6', "mno");
        numbers.put('7', "pqrs");
        numbers.put('8', "tuv");
        numbers.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        dfs(digits, result, 0, "");
        return result;
    }

    public void dfs(String digits, List<String> result, int i, String current) {
        if (current.length() == digits.length()) {
            if (!current.isEmpty()){
                result.add(current);
            }
            return;
        }
        String letters = numbers.get(digits.charAt(i));
        for (Character digit : letters.toCharArray()) {
            dfs(digits, result, i+1, current + digit);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }

}
