import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//965 单值二叉树
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null)  return true;
        if(root.left == null) return (root.val == root.right.val) && isUnivalTree(root.right);
        if(root.right == null) return (root.val == root.left.val) && isUnivalTree(root.left);
        return (root.val == root.left.val) && (root.val == root.right.val) && isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    //bfs
    public boolean isUnivalTree2(TreeNode root){
        if(root == null) return true;
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for(int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if(node.val != value){
                    return false;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return true;
    }


    //dfs
    public boolean isUnivalTree3(TreeNode root){
        ArrayList<Integer> values = new ArrayList<>();
        dfs(root,values);
        for(int v :values){
            if(v != values.get(0)){
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, ArrayList<Integer> values) {
        if(root != null){
            values.add(root.val);
            dfs(root.left, values);
            dfs(root.right, values);
        }
    }


}
