class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(){
            this.key = 0;
            this.val = 0;
            this.prev = null;
            this.next = null;
        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity = 0;
    int size = 0;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            remove(node);
            insert(node);
            return;
        }
        
        if(size == capacity){
            Node node = evict();
            map.remove(node.key);
            size--;
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        size++;
    }
    
    public void insert(Node node){
        Node temp = head.prev;
        temp.next = node;
        node.next = head;
        node.prev = temp;
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
        temp.next.prev = tail;
        tail.next = temp.next;
        
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