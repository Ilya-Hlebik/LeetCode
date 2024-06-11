package TopInterview150.Chapter_1_Array_String.lc_22_6_Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
        }
        boolean zigZag = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            lists.get(j).add(s.charAt(i));
            if (j == numRows - 1) {
                zigZag = true;
                j--;
            } else if (j == 0) {
                zigZag = false;
                j++;
            } else if (!zigZag) {
                j++;
            } else {
                j--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (List<Character> list : lists) {
            result.append(list.stream().map(character -> Character.toString(character)).collect(Collectors.joining()));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("AB", 1));
    }
}
