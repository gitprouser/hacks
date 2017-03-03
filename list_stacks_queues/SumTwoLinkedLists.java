/**
 * Created on 8/17/16.
 */
public class SumTwoLinkedLists {
    static class Node {
        String digits;
        Node prev, next;

        Node(String s, Node prev, Node next) {
            digits = s;
            this.prev = prev;
            this.next = next;
        }

        Node deepCopy() {
            return new Node(this.digits, this.next, this.prev);
        }
    }

    static class LinkedList{
        Node head;
        Node tail;
        int len = 1;

        LinkedList(Node head) {
            this.head = head;
            this.tail = head;
            head.prev = null;
            tail.next = null;
        }

        public void insert(Node node) {
            if (node == null)
                return;
            tail.next = node;
            node.prev = tail;
            tail = node;
            len += 1;
        }

        public void insertTail(Node node) {
            if (node == null)
                return;
            head.prev = node;
            node.next = head;
            head = node;
        }

        public String getAllString() {
            Node curr = head;
            StringBuilder sb = new StringBuilder();
            while (curr != null) {
                sb.append(curr.digits).append("+");
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node("9234", null, null);
        Node head1_1 = new Node("4567", null, null);
        Node head2 = new Node("9678", null, null);
        Node head2_1 = new Node("7878", null, null);

        Node copyHead1_1 = head1_1.deepCopy();
        Node copyHead2_1 = head2_1.deepCopy();

        LinkedList l1 = new LinkedList(head1);
        l1.insert(head1_1);
        l1.insert(copyHead2_1);
        LinkedList l2 = new LinkedList(head2);
        l2.insert(head2_1);
        l2.insert(copyHead1_1);
        System.out.println(l1.getAllString() + " " + l1.len);
        System.out.println(l2.getAllString() + " " + l2.len);
        System.out.println(sum(l1, l2));
    }

    public static String sum(LinkedList h1, LinkedList h2) {
        if (h1 == null)
            return h2.getAllString();
        if (h2 == null)
            return h1.getAllString();

        Node curr_1 = h1.tail;
        Node curr_2 = h2.tail;
        LinkedList tailResult = new LinkedList(new Node("", null,null));

        int carryOver = 0;
        for (; curr_1 != null && curr_2 != null; curr_1 = curr_1.prev, curr_2 = curr_2.prev) {
            String result = String.valueOf(Integer.parseInt(curr_1.digits) + Integer.parseInt(curr_2.digits) + carryOver);
            String result4digit;
            if (result.length() > 4){
                result4digit = result.substring(1);
                carryOver = Integer.parseInt("" + result.charAt(0));
            } else {
                result4digit = result;
                carryOver = 0;
            }
            tailResult.insertTail(new Node(result4digit, null, null));
        }
        if (carryOver > 0) {
            tailResult.insertTail(new Node(String.valueOf(carryOver), null, null));
        }

        return tailResult.getAllString();
    }
}
