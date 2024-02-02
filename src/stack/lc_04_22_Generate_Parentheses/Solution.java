package stack.lc_04_22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1){
            result.add("()");
            return result;
        }
        List<String> list = generateParenthesis(n-1);
        for (String str: list ){
            for (int i = 0; i < str.length(); i++) {
                result.add(new StringBuilder(str).insert(i, "()").toString());
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
