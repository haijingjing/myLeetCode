import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//297 二叉树序列化与反序列化
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        else return root.val + "," + serialize(root.left) +","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return desHelper(list);

    }

    private TreeNode desHelper(List<String> list) {
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        int val = Integer.valueOf(list.get(0));
        TreeNode node = new TreeNode(val);
        list.remove(0);

        node.left = desHelper(list);
        node.right = desHelper(list);

        return node;
    }
}
