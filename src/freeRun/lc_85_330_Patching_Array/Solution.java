package freeRun.lc_85_330_Patching_Array;

public class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int patches = 0;
        while (miss<=n){
            if (i<nums.length && nums[i]<=miss){
                miss+=nums[i++];
            }
            else {
                miss+=miss;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPatches(new int[]{1,12,15}, 43));
    }
}
