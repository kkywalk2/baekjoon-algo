package leetcode;

import java.util.Arrays;

public class RecursiveBuildTree {
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
    
    public void recursiveBuildTree(TreeNode node, int[] preorder, int[] inorder) {
        node.val = preorder[0];
        int rootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (node.val == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        if (rootIdx > 0) {
            node.left = new TreeNode();
            recursiveBuildTree(node.left, Arrays.copyOfRange(preorder, 1, rootIdx + 1),
                    Arrays.copyOfRange(inorder, 0, rootIdx));
        }

        if (rootIdx < inorder.length - 1) {
            node.right = new TreeNode();
            recursiveBuildTree(node.right, Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length));
        }
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode tree = new TreeNode();
        recursiveBuildTree(tree, preorder, inorder);
        return tree;
    }
}
