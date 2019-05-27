import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val == right.val){
            return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
        return false;
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while (!left.isEmpty() && !right.isEmpty()){
            TreeNode node1 = left.poll();
            TreeNode node2 = right.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if( node1 == null || node2 == null){
                return false;
            }
            if( node1.val != node2.val){
                return false;
            }else {
                left.add(node1.left);
                left.add(node1.right);
                right.add(node2.right);
                right.add(node2.left);
            }
        }
        return true;
    }
}
