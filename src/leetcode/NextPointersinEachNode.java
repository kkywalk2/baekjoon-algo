package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Queue<Node> tempQueue = new LinkedList<>();
            Node node = queue.poll();
            if (node.left != null) {
                tempQueue.add(node.left);
                tempQueue.add(node.right);
            }

            while (!queue.isEmpty()) {
                Node next = queue.poll();
                if (next.left != null) {
                    tempQueue.add(next.left);
                    tempQueue.add(next.right);
                }
                node.next = next;
                node = next;
            }
            node.next = null;
            queue = tempQueue;
        }
        return root;
    }
}
