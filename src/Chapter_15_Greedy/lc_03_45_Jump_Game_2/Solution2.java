package Chapter_15_Greedy.lc_03_45_Jump_Game_2;

public class Solution2 {

    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int result = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }
}
