import java.util.ArrayList;
import java.util.List;

//96 不同的二叉搜索树，输出不同的组合

/**
 * 这是卡特兰数的一种应用，采用动态规划：
 1.从start到end，逐个取出一个rootVal作为根节点（n阶原问题）
 2.以根rootVal为界划分为左右子树，并指向左右子树（n-1阶子问题）
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateSubTree(1, n);
    }
    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int rootVal = start; rootVal <= end; rootVal++)
            for (TreeNode leftSubTreeRoot : generateSubTree(start, rootVal - 1))
                for (TreeNode rightSubTreeRoot : generateSubTree(rootVal + 1, end)) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftSubTreeRoot;
                    root.right = rightSubTreeRoot;
                    result.add(root);
                }
        return result;
    }

}
