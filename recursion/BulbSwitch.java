/**
 * Created on 7/24/16.
 */
public class BulbSwitch {

    static class Node {
        int startIdx;
        int endIdx;
        Node left, right;

        Node(int i, int j, Node left, Node right) {
            startIdx = i;
            endIdx = j;
            this.left = left;
            this.right = right;
        }
    }

    static Node buildTree(int numBulbs) {
        return _buildTree(0, numBulbs - 1);
    }

    static Node _buildTree(int i, int j) {
        if (i == j)
            return new Node(i, j, null, null);
        if (i > j)
            return null;
        else {
            Node l = _buildTree(i, (i + j) / 2);
            Node r = _buildTree((i + j)/2 + 1, j);
            return new Node(i, j, l, r);
        }
    }

    public static void main(String[] args) {
        Node root =  buildTree(4);
        System.out.println(root.startIdx);
    }
}