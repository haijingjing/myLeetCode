import java.util.HashMap;

public class CopyListwithRandomPointer {
    HashMap<Node,Node> map = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node newNode = new Node(head.val,new Node(),new Node());
        map.put(head,newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
