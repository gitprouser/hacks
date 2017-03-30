/**
 * Given a binary tree:

       1
     /   \
   -5     2
   / \   /  \
 0   3 -4  -5

 return the node with value 3.

 */

public class BinaryTreeMaximumNode {

    static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode maxNode(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        return max(root, max(left, right));
    }

    public TreeNode max(TreeNode a, TreeNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val > b.val)
            return a;

        return b;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
