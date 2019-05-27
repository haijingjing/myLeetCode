//437 路径之后3
public class PathSumIII {
    //!!!!!!!这是我写的，错误的解法！！！！！！错误的！！
    public int pathSum2(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = pathSum2(root.left,sum) + pathSum2(root.right,sum);
        if(root.val == sum) return res+ pathSum2(root.left,0)+pathSum2(root.right,0) + 1;
        else return res + pathSum2(root.left,sum - root.val) + pathSum2(root.right,sum - root.val);
    }
    /**
     * 这里我们一定要明确pathSumFrom和pathSum的区别。
     * pathSumFrom的含义就是查找包含root并且和为sum的路径个数。
     * 而pathSum是查找不一定包含root并且和为sum的路径个数。
     */

    // 在以root为根结点的二叉树中，寻找和为sum的路径，返回这样的路径个数
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // 在以node为根结点的二叉树中，寻找包含node的路径，和为sum
    // 返回这样的路径个数
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
