import java.util.ArrayList;
import java.util.List;

//13 路径之和2
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<Integer>(),root, sum);
        return res;
    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> temp, TreeNode root, int sum) {
        if(root == null) return;
        temp.add(root.val);
        if(root.left== null && root.right== null && sum == root.val){
            res.add(new ArrayList<>(temp));
        }else {
            backTrace(res, temp, root.left, sum - root.val);
            backTrace(res,temp,root.right, sum - root.val);
        }
        temp.remove(temp.size() - 1);
    }
}
