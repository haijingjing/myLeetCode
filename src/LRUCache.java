import java.util.HashMap;

//146 lru缓存

public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value, Node pre, Node next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    int capacity;
    int count;
    Node head;
    Node tail;
    HashMap<Integer, Node> hm = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 2;
        this.head = new Node(-1,-1,null,null);
        this.tail = new Node(-2,-2,this.head,null);
        this.head.next = this.tail;
        hm = new HashMap<Integer,Node>();
        hm.put(this.head.key, this.head);
        hm.put(this.tail.key, this.tail);

    }

    public int get(int key) {
        int value = -1;
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            value = node.value;
            deteleNode(node);
            insertToHead(node);
        }
        return value;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.value = value;
            deteleNode(node);
            insertToHead(node);
        }else {
            Node newNode = new Node(key, value,null,this.head);
            this.head.pre = newNode;
            this.head = newNode;
            hm.put(key,newNode);
            this.count++;
            if(this.count > capacity){
                removeNode();
            }

        }
    }

    private void removeNode() {
        hm.remove(this.tail.key);
        this.tail = this.tail.pre;
        this.tail.next = null;
        this.count --;
    }

    private void deteleNode(Node node) {
        node.pre.next = node.next;
        if(node.next != null){
            node.next.pre = node.pre;
        }else {
            this.tail = node.pre;
        }
    }
    private void insertToHead(Node node) {
        this.head.pre = node;
        node.next = head;
        node.pre = null;
        this.head = node;
    }
}
