import java.util.*;

public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null){
            return node;
        }
        Queue<GraphNode> queue = new ArrayDeque<GraphNode>();
        Map<GraphNode,GraphNode> map = new HashMap<GraphNode,GraphNode>();
        queue.add(node);
        GraphNode nodeV = new GraphNode(node.val,new ArrayList<GraphNode>());
        map.put(node,nodeV);

        GraphNode graphNode;
        while (!queue.isEmpty()){
            graphNode = queue.poll();
            if(graphNode.neighbors != null){
                for(GraphNode node1:graphNode.neighbors){
                    if(!map.containsKey(node1)){
                        queue.add(node1);
                        GraphNode node2 = new GraphNode(node1.val,new ArrayList<GraphNode>());
                        map.put(node1,node2);
                    }
                    map.get(graphNode).neighbors.add(map.get(node1));
                }
            }
        }

//        for(GraphNode node1:map.keySet()){
//            if(node1.neighbors != null){
//                nodeV = map.get(node1);
//                List<GraphNode> list = new ArrayList<GraphNode>();
//                for(GraphNode node2: node1.neighbors){
//                    list.add(map.get(node2));
//                }
//                nodeV.neighbors = list;
//            }
//        }

        return map.get(node);

    }
}
