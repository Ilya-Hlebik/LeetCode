package Top100Liked.Chapter_3_Binary_Tree.lc_07_108_Convert_Sorted_Array_to_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        int midVal = nums[mid];
        TreeNode root = new TreeNode(midVal);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
