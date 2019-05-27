import java.util.HashMap;

public class MaxWidthOfBinaryTree3 {
    public int widthOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        dfs(root, 0, 0, left, max);
        return max[0];
    }
    public void dfs(TreeNode root, int depth, int pos, HashMap<Integer, Integer> left, int[] max) {
        if (root == null) return;
        if (!left.containsKey(depth)) {
            left.put(depth, pos);
        }
        max[0] = Math.max(max[0], pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos, left, max);
        dfs(root.right, depth + 1, 2 * pos + 1, left, max);
    }
}
