package freeRun.lc_23_116_Populating_Next_Right_Pointers_in_Each_Node;

public class Solution2 {
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node root, Node prev) {
        if (root == null) {
            return;
        }
        if (prev != null) {
            prev.next = root;
        }
        dfs(root.left,prev!=null? prev.right:null);
        dfs(root.right, root.left);
    }
}
