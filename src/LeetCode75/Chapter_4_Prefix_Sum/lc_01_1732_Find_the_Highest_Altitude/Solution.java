package LeetCode75.Chapter_4_Prefix_Sum.lc_01_1732_Find_the_Highest_Altitude;

public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int current = 0;
        for (int num : gain) {
            current += num;
            max = Math.max(max, current);
        }
        return max;
    }
}
