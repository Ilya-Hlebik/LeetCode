package Chapter_1_arrays_and_strings;

public class InvertBinaryTree {
    TreeNode mainRoot;
    boolean needSetRoot = true;
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return mainRoot;
        }
        if (needSetRoot){
            mainRoot = root;
            needSetRoot = false;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return mainRoot;
    }
    public static void main(String[] args) {

    }
}
