//226. 翻转二叉树
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if(root.left != null || root.right != null){
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
