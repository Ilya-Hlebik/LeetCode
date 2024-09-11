
package TopInterview150.Chapter_15_BackTracking.lc_02_77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    public void dfs(int n, int k, List<Integer> current, List<List<Integer>> result, int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            dfs(n, k, current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
}
