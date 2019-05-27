import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94 二叉树中序遍历,左节点根节点右节点
public class BinaryTreeInorderTraversal {
    //递归方法
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null) return res;
        inorderTraversal2(root.left);
        res.add(root.val);
        inorderTraversal2(root.right);
        return res;
    }

    //非递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode node = stack.pop();
                res.add(node.val);
                p = node.right;
            }
        }
        return res;
    }
}
