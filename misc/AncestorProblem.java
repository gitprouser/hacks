import java.util.*;

/**
 * Ancestor problem is to find a common ancestor in the parent hierarchy between two nodes provided as input.
 * egs: a -> b -> c, c
 * Each node will have two parents.  
 * 
 */ 

class AncestorProblem {
    static class Node {
        int val;
        List<Node> parents = new ArrayList<>();

        public void addList(List<Node> parents)  {
            this.parents.addAll(parents); 
        }

        public Node (int i) {
            this.val = i;
        }
    }


    public static void main(String args[]) {
        Node[] children = init();
        for(Node c1 : children) {
            System.out.println(c1.val);
        }
        System.out.println(isCommonAncestor(children));
    }


    public static boolean isCommonAncestor(Node[] children) {
        boolean isCommonAncestor = false;
        Set<Node> visited_c1 = new HashSet<>();
        Set<Node> visited_c2 = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(children[0]);
        queue.offer(children[1]);
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            isCommonAncestor |= visited.contains(parent);
            visited_c1.add(parent);
        }
        return isCommonAncestor;
    }


    static Node[] init () {
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);
        Node p6 = new Node(6);
        Node p7 = new Node(7);
        Node p8 = new Node(8);
        Node p9 = new Node(9);
        Node p10 = new Node(10);
        Node p11 = new Node(11);
        Node p12 = new Node(12);
        Node c1 = new Node(-1);
        Node c2 = new Node(-2);

        Node[] level1_c1 = {p1,p2};
        Node[] level1_c2 = {p3,p4};

        Node[] level2_p1_c1 = {p5,p6};
        Node[] level2_p2_c1 = {p7,p8};

        Node[] level2_p3_c2 = {p9, p10};
        Node[] level2_p4_c2 = {p11, p12};

        p1.addList(Arrays.asList(level2_p1_c1));
        p2.addList(Arrays.asList(level2_p2_c1));

        p1.addList(Arrays.asList(level2_p3_c2));
        p2.addList(Arrays.asList(level2_p4_c2));

        c1.addList(Arrays.asList(level1_c1));
        c2.addList(Arrays.asList(level1_c2));

        Node[] startNode = new Node[2]; startNode[0]= c1; startNode[1] = c2;
        return startNode;
    }

}
