package Interview_prepare.newrub;

public class Solution6 {
    public int[] searchRange(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int searchIndex = -1;
        while (max >= min) {
            int midIndex = min + (max - min) / 2;
            int midVal = nums[midIndex];
            if (midVal == target) {
                searchIndex = midIndex;
                break;
            }
            if (midVal > target) {
                max = midIndex - 1;
            } else {
                min = midIndex + 1;
            }
        }
        if (searchIndex == -1) {
            return new int[]{-1, -1};
        }
        int minIndex = searchIndex;

        while (minIndex - 1 >= 0 && nums[minIndex - 1] == target) {
            minIndex--;
        }
        int maxIndex = searchIndex;
        while (maxIndex + 1 <= nums.length - 1 && nums[maxIndex + 1] == target) {
            maxIndex++;
        }
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        solution6.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

}
