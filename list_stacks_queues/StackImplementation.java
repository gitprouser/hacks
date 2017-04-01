class StackImplementation {
    Node top = null;
    
    class Node {
        int data;
        Node nxt;
        Node (int data, Node nxt) {
            this.data = data;
            this.nxt = nxt;
        }
    }

    public int peek () {
        if (top == null)
            return Integer.MIN_VALUE;
        return top.data;
    }

    public void push (int data) {
        Node currTop = new Node(data, top);
        top = currTop;
    }

    public int pop () throws Exception {
        if (top == null) 
           throw new Exception("StackUnderFlow Exception");
        Node curr = top;
        top = top.nxt; 
        curr.nxt = null; 
        return curr.data;
    }

    public static void main (String args[]) throws Exception {
        StackImplementation stack = new StackImplementation();
        stack.push(10);        
        // System.out.println("peek:" + stack.peek()); 
        stack.push(1);        
        // System.out.println("peek:" + stack.peek()); 
        stack.push(12);        
        // System.out.println("peek:" + stack.peek()); 
        stack.push(13);        
        // System.out.println("peek:" + stack.peek()); 
   
        while (stack != null) {
            System.out.println(stack.peek()); 
            System.out.println(stack.pop()); 
        }
    }
}
