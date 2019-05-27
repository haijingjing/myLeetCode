import java.util.Stack;

//173 二叉搜索树迭代
public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        if(tempNode.right != null){
            TreeNode rightNode = tempNode.right;
            while (rightNode != null){
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return tempNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
