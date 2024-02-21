package Chapter_7_trees.lc_11_98_Validate_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new ArrayList<>());
    }

    public boolean isValidBST(TreeNode root, List<Integer> values) {
        if (root == null){
            return true;
        }
        boolean validLeft = isValidBST(root.left, values);
        if (!values.isEmpty()){
            if (values.get(values.size()-1) >= root.val) {
                return false;
            }
        }
        values.add(root.val);
        boolean validRight = isValidBST(root.right, values);
        return validLeft && validRight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}
