package Top100Liked.Chapter_1_BackTracking.lc_02_22_Generate_Parentheses;

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
        } else {
            List<String> list = generateParenthesis(n - 1);
            for (String s : list) {
                for (int j = 0; j < s.length(); j++) {
                    result.add(new StringBuilder(s).insert(j, "()").toString());
                }
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
