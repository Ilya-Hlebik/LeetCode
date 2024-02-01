package stack.lc_02_155_Min_Stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
 /*       MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    Stack<Integer> minimums = new Stack<>();
    Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node node = new Node(val);
            node.prev = head;
            head.next = node;
            head = node;
        }
        if (minimums.isEmpty() || minimums.peek() > val) {
            minimums.push(val);
        } else {
            minimums.push(minimums.peek());
        }
    }

    public void pop() {
        minimums.pop();
        head = head.prev;
        if (head != null) {
            head.next = null;
        }
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return minimums.peek();
    }
}

class Node {
    public int value;
    public Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}
