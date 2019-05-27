import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph2 {
    public HashMap<GraphNode,GraphNode> map = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null){
            return node;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        GraphNode cloneNode = new GraphNode(node.val,new ArrayList<GraphNode>());
        map.put(node,cloneNode);
        for(GraphNode node1:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(node1));
        }
        return map.get(node);
    }
}
