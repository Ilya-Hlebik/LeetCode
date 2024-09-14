package TopInterview150.Chapter_15_BackTracking.lc_06_22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        if (n == 1) {
            result.add("()");
            return new ArrayList<>(result);
        }
        List<String> list = generateParenthesis(n - 1);
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                result.add(new StringBuilder(s).insert(i, "()").toString());
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(4));
    }
}
