//二叉树最大宽度
public class MaxWidthOfBinaryTree {
    TreeNode root;

    int height(TreeNode node){
        if(node == null){
            return 0;
        }else {
            int lheight = height(node.left);
            int rheight = height(node.right);
            return 1+Math.max(lheight,rheight);
        }
    }

    int getMax(int count[], int n){
        int max = 0;
        for(int i = 0;i<n; i++){
            if(count[i]>max){
                max = count[i];
            }
        }
        return max;
    }
    void getMaxWidthRecur(TreeNode node, int count[], int level){
        if(node!=null){
            count[level]++;
            getMaxWidthRecur(node.left,count,level+1);
            getMaxWidthRecur(node.right,count,level+1);
        }
    }
    int getMaxWidth(TreeNode node){
        int width;
        int h = height(node);
        int count[] = new int[10];
        int level = 0;
        getMaxWidthRecur(node,count,level);
        return getMax(count,h);
    }
}
