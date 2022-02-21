class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(){
            this.key = 0;
            this.val = 0;
            this.next = null;
            this.prev = null;
        }
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
            
        }
        
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int size = 0;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        
        head.prev = tail;
        tail.next = head;
        
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        
        return node.val;
    }
    
    
    // 1:2, 2:3, 3:4, 4:5, 
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            remove(node);
            insertAtHead(node);
            return;
        }
        
        if(size == capacity){
            Node node = evict();
            map.remove(node.key);
            size--;
        }
        
        Node node = new Node(key, value);
        insertAtHead(node);
        map.put(key, node);
        size++;
    }
    
    public void insertAtHead(Node node){
        Node temp = head.prev;
        temp.next = node;
        node.prev = temp;
        node.next = head;
        head.prev = node;
    }
    
    public void remove(Node node){
        Node prev_ = node.prev;
        Node next_ = node.next;
        prev_.next = next_;
        next_.prev = prev_;
        node.next = null;
        node.prev = null;
        
    }
    
    public Node evict(){
        Node temp = tail.next;
        tail.next = temp.next;
        temp.next.prev = tail;
        temp.next = null;
        temp.prev = null;
        
        return temp;
            
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */