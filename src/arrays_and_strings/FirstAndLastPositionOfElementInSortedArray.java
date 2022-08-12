package arrays_and_strings;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange1(int[] nums, int target) {
        int result[] = new int[]{-1,-1};
        boolean isFirst = true;
        for (int i = 0; i < nums.length; i++) {
            if (isFirst && target == nums[i]){
                result[0] = i;
                isFirst = false;
            }
            else if (target == nums[i]){
                result[1] = i;
            }
        }
        if (result [1] == -1){
            result [1] = result [0];
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        FirstAndLastPositionOfElementInSortedArray firstAndLastPositionOfElementInSortedArray = new FirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}));
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5,7,7,8,8,10}, 6), new int[]{-1,-1}));
        System.out.println(Arrays.equals(firstAndLastPositionOfElementInSortedArray.searchRange(new int[]{}, 0), new int[]{-1,-1}));

    }
}
