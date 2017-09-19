import java.util.*;


class PreorderInorderTreeSerializer {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        TreeNode root = init();
        System.out.println(serialize(root));
    }


    public static String serialize(TreeNode root) {
        if (root == null)
            return "";

        return preOrder(new StringBuilder(), root)  + "# " + inOrder(new StringBuilder(), root);
    }


    private static String preOrder(StringBuilder sb, TreeNode root) {
        if (root == null) 
            return "";

        sb.append(root.val).append(" ");
        preOrder(sb, root.left);
        preOrder(sb, root.right);
        return sb.toString();
    }


    private static String inOrder(StringBuilder sb, TreeNode root) {
        if (root == null)
            return "";

        inOrder(sb, root.left);
        sb.append(root.val).append(" ");
        inOrder(sb, root.right);
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] twoParts = data.split("#");
        int[] preOrder = convertToIntArray(twoParts[0]);
        int[] inOrder = convertToIntArray(twoParts[1]);
        assert preOrder.length == inOrder.length;
        // preprocess
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; ++i)
            map.put(inOrder[i], i);

        // reconstruct tree
        return deseralizeHelper(preOrder, 0, inOrder, 0, inOrder.length - 1, map);
    }

    private TreeNode deseralizeHelper(int[] preOrder, int pre_index,
        int[] inOrder, int in_start, int in_end, Map<Integer, Integer> map)
    {
        if (in_end < in_start)
            return null;

        int rootValue = preOrder[pre_index];
        TreeNode root = new TreeNode(rootValue); 
        int in_pos = map.get(rootValue); 
        int left_len = in_pos - in_start; 
        root.left = deseralizeHelper(preOrder, pre_index + 1, inOrder, in_start, in_pos - 1, map); 
        root.right = deseralizeHelper(preOrder, pre_index + 1 + left_len, inOrder, in_pos + 1, in_end, map); 
        return root;
    }

    private int[] convertToIntArray(String traversalStr) {
        String[] fields = traversalStr.split(" ");
        int[] traversalArr = new int[fields.length];
        for (int i = 0; i < fields.length; ++i)
            traversalArr[i] = Integer.parseInt(fields[i]);

        return traversalArr;
    }



/**

        _______7______
       /              \
    __10__          ___2
   /      \        /
  4        3      _8
            \    /
             1  11

*/

    static TreeNode init () {
        TreeNode p7 = new TreeNode(7);
        TreeNode p10 = new TreeNode(10);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p8 = new TreeNode(8);
        TreeNode p11 = new TreeNode(11);
        p7.left = p10;
        p7.right = p2;
        p10.left = p4;
        p10.right = p3;
        p3.right = p1;
        p2.left = p8;
        p8.left = p11;
        return p7;
    }
}
