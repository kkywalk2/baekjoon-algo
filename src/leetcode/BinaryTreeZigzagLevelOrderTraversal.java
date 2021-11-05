package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root != null)
            stack.push(root);

        boolean zigzag = true;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);

                if(!zigzag) {
                    if (node.right != null)
                        tempStack.push(node.right);
                    if (node.left != null)
                        tempStack.push(node.left);
                } else {
                    if (node.left != null)
                        tempStack.push(node.left);
                    if (node.right != null)
                        tempStack.push(node.right);
                }
            }
            zigzag = !zigzag;
            stack = tempStack;
            result.add(list);
        }
        return result;
    }
}
