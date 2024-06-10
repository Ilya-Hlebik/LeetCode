package TopInterview150.Chapter_1_Array_String.lc_15_135_Candy;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        return Arrays.stream(res).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1, 3, 2, 2, 1}));
    }
}
