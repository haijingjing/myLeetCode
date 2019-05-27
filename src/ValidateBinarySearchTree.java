import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//98 验证二叉搜索树
public class ValidateBinarySearchTree {
    //思路，中序遍历，如果单调递增，就是二叉搜索树
    /*public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()){
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        for(int i = 1; i < res.size(); i++){
            if(res.get(i) <= res.get(i-1)){
                return false;
            }
        }
        return true;
    }
*/


    //题解思路，缩小边界值，递归判断
    public boolean isValidBST(TreeNode root) {
        if(root ==  null) return  true;
        return helper(root.left, null, root.val) && helper(root.right, root.val, null);
    }


    private boolean helper(TreeNode node, Integer loBound, Integer hiBound){
        if(node == null) return true;
        if(loBound != null && node.val <= loBound) return false;
        if(hiBound != null && node.val >= hiBound) return false;
        return helper(node.left, loBound, node.val) && helper(node.right, node.val, hiBound);
    }
}
