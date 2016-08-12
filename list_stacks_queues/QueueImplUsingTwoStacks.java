import java.util.Stack;

/**
 * Created on 8/7/16.
 */
public class QueueImplUsingTwoStacks {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;
    LinkedListNode result;

    static class LinkedListNode {
        int data;
        LinkedListNode _next;

        LinkedListNode(int data) {
            this.data = data;
            this._next = null;
        }
    }

    QueueImplUsingTwoStacks() {
        inputStack = new Stack();
        outputStack = new Stack();
        result = new LinkedListNode(-10);  // Root node
    }

    static LinkedListNode queueImplUsingTwoStacks(LinkedListNode operationsList) {
        throw new UnsupportedOperationException("nyimpl");
    }

    void enqueue() {
        inputStack.push(123);
    }


    static void dequeue() {

    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode(1);
        list._next = new LinkedListNode(2);
        list._next._next = new LinkedListNode(-1);
        list._next._next._next = new LinkedListNode(-1);
        queueImplUsingTwoStacks(list);
    }

}
