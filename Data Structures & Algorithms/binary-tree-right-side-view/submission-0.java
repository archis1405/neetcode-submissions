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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root==null){
            return ans;
        }

        solve(0,root,ans);

        return ans;
    }

    public void solve(int level , TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }

        if(level==ans.size()){
            ans.add(root.val);
        }

        solve(level+1 , root.right , ans);
        solve(level+1 , root.left , ans);
    }
}
