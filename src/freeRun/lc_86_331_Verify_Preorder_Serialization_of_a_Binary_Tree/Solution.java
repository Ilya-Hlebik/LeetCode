package freeRun.lc_86_331_Verify_Preorder_Serialization_of_a_Binary_Tree;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            stack.push(node);
            while (stack.size() > 2
                    && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#") && !stack.get(stack.size() - 3).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && Objects.equals(stack.pop(), "#");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
