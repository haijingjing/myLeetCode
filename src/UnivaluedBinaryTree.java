//965 单值二叉树
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null)  return true;
        if(root.left == null) return (root.val == root.right.val) && isUnivalTree(root.right);
        if(root.right == null) return (root.val == root.left.val) && isUnivalTree(root.left);
        return (root.val == root.left.val) && (root.val == root.right.val) && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
