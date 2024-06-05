package LeetCode75.Chapter_19_Bit_Manipulation.lc_03_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c;

public class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        if ((a | b) == c) {
            return count;
        }
        for (int i = 0; i < 32; i++) {
            if ((c & (1 << i)) == 0) {
                if (((a & (1 << i)) != 0)) {
                    count++;
                }
                if ((b & (1 << i)) != 0) {
                    count++;
                }
            } else if ((c & (1 << i)) != 0 && (a & (1 << i)) == 0 && ((b & (1 << i)) == 0)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlips(1, 2, 3));
    }
}
