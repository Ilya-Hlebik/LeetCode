package Chapter_10_backtracking.lc_03_46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        function(ans, nums, 0);
        return ans;
    }

    public void function(List<List<Integer>> ans, int[] arr, int start) {
        if (start == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int value : arr) {
                list.add(value);
            }
            ans.add(list);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            function(ans, arr, start + 1);
            swap(arr, start, i);
        }
    }

    public void swap(int[] arr, int a, int b) {
        if (a == b){
            return;
        }
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}
