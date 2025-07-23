package freeRun.lc_29_164_Maximum_Gap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        if (nums.length == 2){
            return Math.abs(nums[0] - nums[1]);
        }
        int max = Arrays.stream(nums).max().getAsInt();

        for (int position = 1; max / position > 0; position += 10) {
            countSort(nums, position, max);
        }
        int minGap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minGap = Math.max(minGap, nums[i] - nums[i - 1]);
        }
        return minGap;
    }

    private void countSort(int[] nums, int position, int max) {
        int[] count = new int[10];
        int[] out = new int[nums.length + 1];
        for (int el : nums) {
            count[(el / position) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = count.length - 1; i > 0; i--) {
            count[i] = count[i - 1];
        }
        count[0] = 0;
        for (int num : nums) {
            out[count[(num / position) % 10]++] = num;
        }
        System.arraycopy(out, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGap(new int[]{494767408,862126209,213511142,768240025,631263193,839199222,990848796,214568815,540853864,760724418,980162605,976743981,168965760,680875496,256709197,970953816,948680062,347254784,732201399,786249847,782805044,40906641,674241381,784330934,175502610,731105392,424650824,549764101,986090032,710542549,249208107,448419816,527708664,158499246,223421723,114552457,466978424,821491411,19614107,115389497,902211438,2644108,744489871,897895073,372311214,551142753,933294894,426217662,217504874,983488406,516890023,426853110,971124103}));
    }
}
