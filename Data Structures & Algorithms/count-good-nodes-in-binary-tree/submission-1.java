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
    public int goodNodes(TreeNode root) {
        int ans = solve(root , root.val);

        return ans;
    }

    public int solve(TreeNode root , int pathMax){
        if(root == null){
            return 0;
        }

        int cnt = 0;

        if(root.val >= pathMax){
            cnt = 1;
        }

        pathMax = Math.max(pathMax , root.val);

        cnt = cnt + solve(root.left , pathMax);
        cnt = cnt + solve(root.right , pathMax);

        return cnt;
    }
    
}
