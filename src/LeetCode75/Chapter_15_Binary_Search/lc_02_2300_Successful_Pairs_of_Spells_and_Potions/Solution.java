package LeetCode75.Chapter_15_Binary_Search.lc_02_2300_Successful_Pairs_of_Spells_and_Potions;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long spell = spells[i];
            res[i] = binarySearch(potions, (int) Math.ceil(success / (double) spell));
        }
        return res;
    }

    private int binarySearch(int[] potions, int number) {
        int l = 0;
        int r = potions.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = potions[mid];
            if (midValue >= number) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return potions.length - l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }
}
