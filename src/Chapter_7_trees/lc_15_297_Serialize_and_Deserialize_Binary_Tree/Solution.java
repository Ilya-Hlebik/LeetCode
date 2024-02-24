package Chapter_7_trees.lc_15_297_Serialize_and_Deserialize_Binary_Tree;

import Chapter_7_trees.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node ==null){
                    result.append("null ");
                    continue;
                }
                result.append(node.val).append(" ");
                queue.add(node.left);
                queue.add(node.right);
            }
            if (queue.stream().allMatch(Objects::isNull)){
                break;
            }
        }
        return result.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.trim().split(" ");
        if (split.length==0 || split[0].equals("null")){
            return null;
        }
        int index = 0;
        Queue<TreeNode>queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < split.length){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                String left = split[index++];
                String right = split[index++];
                if (!left.equals("null")){
                    poll.left = new TreeNode(Integer.parseInt(left));
                    queue.add(poll.left);
                }
                if (!right.equals("null")){
                    poll.right = new TreeNode(Integer.parseInt(right));
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
/*        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(9);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        String serialize = solution.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println();
    }
}
