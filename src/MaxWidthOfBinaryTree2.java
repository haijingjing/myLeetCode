import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidthOfBinaryTree2 {
    int maxWidth(TreeNode node){
        if(node == null){
            return 0;
        }
        int max = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(node);

        while (true){
            int len = queue.size();
            if(len == 0) break;
            while (len>0){
                TreeNode treeNode = queue.poll();
                len--;
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            max = Math.max(max,queue.size());
        }
        return max;
    }
}
