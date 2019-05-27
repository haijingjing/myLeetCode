import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144 二叉树前序遍历
public class BinaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();
    //递归方法
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root == null) return res;
        res.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
        return res;
    }

    //非递归方法
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        if(cur != null){
            stack.push(cur);
        }
        while (!stack.empty()){
            cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }
}
