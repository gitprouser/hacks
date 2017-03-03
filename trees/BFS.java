import java.util.Queue;
import java.util.Stack;

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
        @Override
        public String toString() {
            return new String() + data;
        }
    }

    static Node _buildTree(int data) {
        return new Node(data, null, null);
    }

    /**
     *              14
     *       3              25
     *  1       12       23         89
     *       123
     * @param args
     */
    public static void main(String[] args) {
        Node root = _buildTree(14);
        Node left1 = _buildTree(3);
        Node right1 = _buildTree(25);
        Node leftLeft2 = _buildTree(1);
        Node rightLeft2 = _buildTree(124);
        Node leftRight2 = _buildTree(23);
        Node rightRight2 = _buildTree(89);
        Node leftRightLeft3 = _buildTree(7);
        root.left = left1;
        root.right = right1;

        left1.left = leftLeft2;
        left1.right = rightLeft2;

        right1.left = leftRight2;
        right1.right = rightRight2;
        rightLeft2.left = leftRightLeft3;
//
//        preorder(root);
//        System.out.println();
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//        breadthFirst(queue);
//        System.out.println();
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        dfsTraverse(stack);
        System.out.println(isBST(root));
    }

    static void preorder(Node curr) {
        if (curr != null) {
            System.out.print(curr.data + " ");
            preorder(curr.left);
            preorder(curr.right);
        }
    }

    static void breadthFirst(Queue<Node> queue) {
        while(!queue.isEmpty()) {
            Node curr = queue.peek();
            if(curr != null) {
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                System.out.print(queue.remove() + " ");
            }
        }
    }

    static void dfsTraverse(Stack<Node> stack) {
        while(!stack.empty()) {
            Node curr = stack.pop();
            if (curr != null) {
                System.out.print(curr + " ");
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
    }


    static boolean isBST(Node root) {
        if ((root != null) && (root.left == null) && (root.right == null))
            return true;
        if ((root != null)&& (root.left != null) && (root.right == null))
            return ((root.left.data < root.data) && isBST(root.left));
        if ((root != null) && (root.left == null) && (root.right != null))
            return (root.right.data > root.data && isBST(root.right));

        return ((root.left.data < root.data) && root.right.data > root.data && isBST(root.left) && isBST(root.right));
    }
}
