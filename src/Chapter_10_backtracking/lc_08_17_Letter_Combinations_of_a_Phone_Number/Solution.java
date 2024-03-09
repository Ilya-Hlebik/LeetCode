package Chapter_10_backtracking.lc_08_17_Letter_Combinations_of_a_Phone_Number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, String> numbers = new HashMap<>();

    {
        numbers.put(2, "abc");
        numbers.put(3, "def");
        numbers.put(4, "ghi");
        numbers.put(5, "jkl");
        numbers.put(6, "mno");
        numbers.put(7, "pqrs");
        numbers.put(8, "tuv");
        numbers.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {

    }

    public String dfs(List<Integer> digits, List<String> result) {

        for (Integer digit: digits){
            
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }

}
