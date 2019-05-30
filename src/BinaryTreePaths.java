import java.util.ArrayList;
import java.util.List;

//257 二叉树路径
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        dfs(root, res, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, List<String> res, StringBuilder sb) {
        if(root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        else {
            sb.append("->");
            dfs(root.left, res, sb);
            dfs(root.right, res, sb);
        }
        sb.setLength(len);
    }
}
