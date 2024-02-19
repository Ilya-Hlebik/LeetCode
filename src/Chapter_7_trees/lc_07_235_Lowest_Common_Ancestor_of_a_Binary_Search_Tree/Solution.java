package Chapter_7_trees.lc_07_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import Chapter_7_trees.TreeNode;

public class Solution {
    TreeNode result = null;
    int maxHeight = -1;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor(root, p, q, 0);
        return result;
    }

    public void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int height) {
        if (root == null) {
            return;
        }
        lowestCommonAncestor(root.left, p, q, height + 1);
        lowestCommonAncestor(root.right, p, q, height + 1);
        if (height > maxHeight) {
            ContainsPAndQ containsPAndQ = new ContainsPAndQ();
            containsBoth(root, p, q, 0, containsPAndQ);
            if (containsPAndQ.containsP && containsPAndQ.containsH) {
                maxHeight = height;
            }
        }
    }

    private void containsBoth(TreeNode root, TreeNode p, TreeNode q, int height, ContainsPAndQ containsPAndQ) {
        if (root == null) {
            return;
        }
        containsBoth(root.left, p, q, height + 1, containsPAndQ);
        containsBoth(root.right, p, q, height + 1, containsPAndQ);
        if (root.val == p.val) {
            containsPAndQ.containsP = true;
        }
        if (root.val == q.val) {
            containsPAndQ.containsH = true;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
    }
}

class ContainsPAndQ {
    public boolean containsP = false;
    public boolean containsH = false;
}
