/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(root , sb);

        return sb.toString();
    }

    public void preorder(TreeNode root , StringBuilder sb){
        if(root==null){
            sb.append("*").append(",");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left , sb);
        preorder(root.right , sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        int[] index = new int[1];
        index[0] = 0;

        return treeBuilder(nodes , index);
    }

    public TreeNode treeBuilder(String[] nodes , int[] index){
        if(nodes[index[0]].equals("*")){
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;

        root.left = treeBuilder(nodes , index);
        root.right = treeBuilder(nodes , index);

        return root;
    }
}
