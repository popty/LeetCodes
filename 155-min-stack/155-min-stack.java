class MinStack {

    class Node{
        int val;
        int minSoFar;
        Node next;
        
        Node(int val){
            this.val = val;
            this.next = null;
            this.minSoFar = Integer.MAX_VALUE;
        }
    }
    
    Node head;
    public MinStack() {
       this.head = new Node(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        if(val < this.head.minSoFar){
            node.minSoFar = val;
        }else{
            node.minSoFar = this.head.minSoFar;
        }
        
        
       head = node;
    }
    
    public void pop() {
       head = head.next;
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.minSoFar;    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */