package Chapter_15_Greedy.lc_04_134_Gas_Station;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentFuel = 0;
        boolean isStartingPoint = true;
        Set<Integer> visited = new HashSet<>();
        int triedStarts = 0;
        for (int i = 0; i < gas.length; i++, i %= gas.length) {
            if (triedStarts == gas.length) {
                return -1;
            }
            if (!isStartingPoint) {
                if (i == 0) {
                    currentFuel -= cost[gas.length - 1];
                } else {
                    currentFuel -= cost[i - 1];
                }
            }
            isStartingPoint = false;
            if (currentFuel < 0) {
                visited.clear();
                currentFuel = 0;
                isStartingPoint = true;
                i = triedStarts++;
                continue;
            }
            currentFuel += gas[i];
            if (visited.contains(i)) {
                return i;
            }
            visited.add(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
