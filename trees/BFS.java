/**
 * Created on 8/4/16.
 */
public class BFS {
    static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node _buildTree(int data) {
        return new Node(data, null, null);
    }

    public static void main(String[] args) {
        Node root = _buildTree(14);
        Node left1 = _buildTree(3);
        Node right1 = _buildTree(10);
        Node leftLeft2 = _buildTree(1);
        Node rightLeft2 = _buildTree(2);
        Node leftRight2 = _buildTree(23);
        Node rightRight2 = _buildTree(89);
        root.left = left1;
        root.right = right1;

        left1.left = leftLeft2;
        left1.right = rightLeft2;

        right1.left = leftRight2;
        right1.right = rightRight2;

        System.out.println(root.data);
        preorder(root);
    }

    static void preorder(Node curr) {
        if (curr != null) {
            System.out.print(curr.data + " ");
            preorder(curr.left);
            preorder(curr.right);
        }
    }

}
