//235 二叉搜索树的最近公共祖先
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root  == q) return root;
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) return root;
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else {
                return root;
            }
        }
        return root;
    }
}
