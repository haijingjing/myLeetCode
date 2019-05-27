import java.util.*;

//107 二叉树的层次遍历 II
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  listList = new ArrayList<>();
        if(root == null) return  listList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true){
            int len = queue.size();
            if(len == 0) break;
            List<Integer>  list = new ArrayList<>();
            while (len > 0){
                TreeNode node = queue.poll();
                len --;
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            //指定位置插入list，这样就不用反转了
            listList.add(0,list);
        }
        //正常插入listList.add(list)需要反转一次
//        Collections.reverse(listList);
        return listList;
    }
    //dfs，递归方法
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>>  result = new LinkedList<>();
        levelRecursion(root,result,0);
        return result;
    }

    private void levelRecursion(TreeNode node,
                                LinkedList<List<Integer>> result, int level) {
        if(node == null) return;
        if(result.size() <= level){//result.size正常应该比level大1，因为level从0开始
            result.add(0,new ArrayList<>());
        }
        result.get(result.size() - level - 1).add(node.val);
        levelRecursion(node.left,result,level+1);
        levelRecursion(node.right,result,level+1);
    }
}
