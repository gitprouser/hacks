1.find min and max element in a binary search tree

class MinMaxFloorTreeProblem {
  Node min (Node root) {
      if (root == null)
          return null;

      if (root.left == null)
          return root;
      return min(root.left);
  }

  Node max(Node root) {
      if (root == null)
          return null;

      if (root.right == null)
          return root;
      return max(root.right);
  }

  /*
          10  
       2        15
     -1  7   14  16
           9
      floor(8)
      floor(2)
      10
      2
      7
  */

  Node floor (Node root, int key) {
      if (root == null)
          return null;

      if (key == root.data  || (key > root.data && root.right == null)
                            || (key > root.data && key < root.right.data))
          return root;

      if (key < root.data) {
          return floor(root.left);
      }

      if (key > root.data) {
          return floor(root.right);
      } 
  }

  class   Node {
      int data;
      Node left, right;
  }


  /*
          10  
       2        15
     -1  7   14  16
          9
      -1, 
      floor (16)
  */
}
