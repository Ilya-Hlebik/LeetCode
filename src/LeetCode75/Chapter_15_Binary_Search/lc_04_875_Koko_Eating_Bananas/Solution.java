package LeetCode75.Chapter_15_Binary_Search.lc_04_875_Koko_Eating_Bananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min = 1;
        int res = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int temp = 0;
            for (int pile : piles) {
                temp += (int) Math.ceil(pile / (double) mid);
                if (temp > h) {
                    break;
                }
            }
            if (temp <= h) {
                res = Math.min(res, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
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
