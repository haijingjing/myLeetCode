import java.util.List;

//559 N叉树的最大深度
public class MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if(root == null) return  0;
        else return maxDepthofList(root.children) + 1;
    }

    private int maxDepthofList(List<Node> children) {
        int max = 0;
        for(Node child: children){
            int depth = maxDepth(child);
            if(max < depth) max = depth;
        }
        return max;
    }
}
