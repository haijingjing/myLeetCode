import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode2 {
    public Node connect2(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true){
            int len = queue.size();
            if(len == 0) break;
            while (len >0){
                Node node = queue.poll();
                len --;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(len > 0){
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }

    public Node connect(Node root) {
        Node queue = root;
        Node level = new Node();
        while (queue != null){
            level.next = null;
            Node cur = level;
            while (queue != null){
                if(queue.left != null){
                    cur.next = queue.left;
                    cur = cur.next;
                }
                if(queue.right != null){
                    cur.next = queue.right;
                    cur = cur.next;
                }
                queue = queue.next;
            }
            queue = level.next;
        }
        return root;
    }
}
