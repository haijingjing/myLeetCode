//337 打家劫舍3
public class HouseRobberIII {
    //递归非记忆化搜索
    public int rob(TreeNode root){
        if(root == null) return 0;
        int s0 = 0;
        int s1 = root.val;
        s0 = rob(root.left) + rob(root.right);

        if(root.left != null){
            s1 += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            s1 += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(s0, s1);
    }

    //递归记忆化搜索
    public int rob2(TreeNode root){
        int[] res = subRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] subRob(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] left = subRob(root.left);
        int[] right = subRob(root.right);
        int[] res = new int[2];

        //0表示没偷当前节点，1表示偷了
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
