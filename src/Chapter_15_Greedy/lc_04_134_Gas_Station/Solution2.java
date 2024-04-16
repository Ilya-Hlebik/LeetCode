package Chapter_15_Greedy.lc_04_134_Gas_Station;

import java.util.Arrays;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
