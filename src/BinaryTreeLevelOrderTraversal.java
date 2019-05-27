import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102 二叉树层级遍历
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true){
            int len = queue.size();
            if(len == 0) break;
            List<Integer> list = new ArrayList<>();
            while (len > 0){
                len --;
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
