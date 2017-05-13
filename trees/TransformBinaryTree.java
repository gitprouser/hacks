/**
 * 
    Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
    For example, the following tree
    
                 10
              /      \
            -2        6
           /   \     /  \
         8     -4   7    5
    
    should be changed to
    
           20(4-2+12+6)
              /              \
         4(8-4)      12(7+5)
           /   \           /  \
         0      0       0    0
    
    Input:
    
    The task is to complete the method which takes one argument, root of Binary Tree. There are multiple test cases. For each test case, this method will be called individually.
    
    Output:
    The function convert the passed tree to its sum tree.  
    
    Constraints:
    1 <=T<= 30
    1 <=Number of nodes<= 100
    1 <=Data of a node<= 1000
    
    Example:
    Input:
    2
    2
    3 1 L 3 2 R
    4
    10 20 L 10 30 R 20 40 L 20 60 R
    
    Output:
    
    0 3 0 
    0 100 0 150 0
    
    The output in this sample test case is Inorder traversal of modified tree.
    
    There are two test casess.  First case represents a tree with 3 nodes and 2 edges where root is 3, left child of 3 is 1 and right child of 3 is 2.   Second test case represents a tree with 4 edges and 5 nodes.
    
    http://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
     
*/


class TransformBinaryTree {

	static class Node {
		int data;
		Node left, right;
		
		Node (Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}

	public static void main (String args[]) {
		// Test Case #1
		System.out.println("############  Test Case #1  ############");	
		Node root_left_left = new Node(null, null, 40);	
		Node root_left_righ = new Node(null, null, 60);	
		Node root_right = new Node(null, null, 30);	
		Node root_left = new Node(root_left_left, root_left_righ, 20);	
		Node root = new Node(root_left, root_right, 10);	
		toSumTree(root);
        _postOrderTraversal(root);
		System.out.println("\n############  Test Case #2  ############");	
		// Test Case #2 	
		root_right = new Node(null, null, 3);	
		root_left = new Node(null, null, 2);	
		root = new Node(root_left, root_right, 1);	
		toSumTree(root);
        _postOrderTraversal(root);
		System.out.println();	
	}     


	public static void toSumTree(Node root) {
        root.data = helper(root.left) + helper(root.right);
    }
    
    static int helper(Node root) { // replace root's value with
    // the sum of its children, and return its own value + sum
        if (root == null) {
            return 0;
        }
        int tmp = root.data;
        int left = helper(root.left);
        int right = helper(root.right);
        root.data = left + right;
        return tmp + root.data;
    }



	public static void ___toSumTree(Node root) {
        _toSumTree(root);
        _postOrderTraversal(root);
    }

    public static int _toSumTree(Node root) {
        if (root == null) {
            return 0;
        } else {
            int data = _toSumTree(root.left) + _toSumTree(root.right);
            int val = root.data;
            root.data = data;
            return data + val;
        }
    }

    public static void _postOrderTraversal(Node root) {
        if (root == null) return;
        else {
            _postOrderTraversal(root.left);
            System.out.print(root.data + " ");
            _postOrderTraversal(root.right);
        }
    }
}
