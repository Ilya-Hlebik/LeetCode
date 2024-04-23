package Chapter_5_binary_search.lc_03_875_Koko_Eating_Bananas;

import java.util.Arrays;

public class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        return search(piles, h, 1, max, max);
    }

    private int search(int[] piles, int h, int min, int max, int result) {
        int finalRes = result;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int tempH = 0;
            for (int temp : piles) {
                tempH += Math.ceil((double) temp / mid);
                if (tempH > h) {
                    break;
                }
            }
            if (tempH <= h) {
                finalRes = Math.min(mid, finalRes);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return finalRes;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 20));
        System.out.println(solution.minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
