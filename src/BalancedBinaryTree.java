//110. 平衡二叉树
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(findDepth(root.left) - findDepth(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int findDepth(TreeNode root) {
        if(root == null) return 0;
        else return Math.max(findDepth(root.left),findDepth(root.right))+1;
    }

}
