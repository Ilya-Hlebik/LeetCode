package TopInterview150.Chapter_23_Multidimensional_DP.lc_01_120_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalHelper(triangle, 0, 0, new Integer[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1]);
    }

    public int minimumTotalHelper(List<List<Integer>> triangle, int listIndex, int elementIndex, Integer[][] memo) {
        if (listIndex > triangle.size() - 1 || elementIndex > triangle.get(listIndex).size() - 1) {
            return 0;
        }
        if (memo[listIndex][elementIndex] != null) {
            return memo[listIndex][elementIndex];
        }
        return memo[listIndex][elementIndex] = triangle.get(listIndex).get(elementIndex) + Math.min(minimumTotalHelper(triangle, listIndex + 1, elementIndex, memo),
                minimumTotalHelper(triangle, listIndex + 1, elementIndex + 1, memo));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }
}
