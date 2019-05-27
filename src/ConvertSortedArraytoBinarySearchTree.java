import java.util.HashSet;

//108. 将有序数组转换为二叉搜索树
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length == 0) return null;
        return buildBST(nums,0,length-1);
    }

    private TreeNode buildBST(int[] nums, int low, int high) {
        if (low <= high){
            int mid = (low + high) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBST(nums, low,mid - 1);
            node.right = buildBST(nums,mid + 1,high);
            return node;
        }
        return null;
    }
}
