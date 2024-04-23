package Chapter_5_binary_search.lc_03_875_Koko_Eating_Bananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        return search(piles, h, 1, max, max);
    }

    private int search(int[] piles, int h, int min, int max, int result) {
        if (min > max) {
            return result;
        }
        int mid = min + (max - min) / 2;
        int tempH = 0;
        for (int temp : piles) {
            tempH += Math.ceil((double) temp / mid);
            if (tempH > h) {
                break;
            }
        }
        if (tempH <= h) {
            return Math.min(mid, search(piles, h, min, mid - 1, mid));
        }
        return search(piles, h, mid + 1, max, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 20));
        System.out.println(solution.minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
