package Interview_prepare;

public class IsItBinarySearchTree {

    public static void main(String[] args) {
        IsItBinarySearchTree isItBinarySearchTree = new IsItBinarySearchTree();
        TreeNode node = new TreeNode(6);
        TreeNode right = new TreeNode(8);
        node.right =right;
        right.left = (new TreeNode(7));


        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        isItBinarySearchTree.printInorder(node);
    }

    void printInorder(TreeNode node) {
        if (node == null)
            return;

        /* first recur on left child */

        printInorder(node.left);
        System.out.print(node.val + " ");
        /* then print the data of node */


        /* now recur on right child */
        printInorder(node.right);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
