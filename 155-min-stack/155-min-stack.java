class MinStack {

    class Node{
        int val;
        int minSoFar;
        Node next; 
        Node prev;
        
        Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
            this.minSoFar = Integer.MAX_VALUE;
        }
    }
    
    Node head;
    public MinStack() {
       this.head = new Node(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        Node node = new Node(val);
        this.head.next = node;
        node.prev = head;
        if(val < this.head.minSoFar){
            node.minSoFar = val;
        }else{
            node.minSoFar = this.head.minSoFar;
        }
        
        
        this.head = this.head.next;
    }
    
    public void pop() {
        System.out.println("Popping head "+head.val);
        this.head = head.prev;
        
        this.head.next = null;
    }
    
    public int top() {
        return this.head.val;
        
    }
    
    public int getMin() {
        return this.head.minSoFar;    
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