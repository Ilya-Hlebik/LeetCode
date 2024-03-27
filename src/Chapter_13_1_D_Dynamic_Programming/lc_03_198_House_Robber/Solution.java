package Chapter_13_1_D_Dynamic_Programming.lc_03_198_House_Robber;

public class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }
}
