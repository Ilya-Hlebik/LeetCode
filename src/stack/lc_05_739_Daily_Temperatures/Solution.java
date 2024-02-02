package stack.lc_05_739_Daily_Temperatures;

import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            boolean wasHigher = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                count++;
                if (temperatures[i] < temperatures[j]) {
                    wasHigher = true;
                    break;
                }
            }
            result[i] = wasHigher ? count : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30,60,90})));
    }
}
