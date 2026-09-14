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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);

        return maxSum;    
    }

    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);


        int case1Sum = leftSum + rightSum + root.val;
        int case2Sum = Math.max(leftSum , rightSum) + root.val;
        int case3Sum = root.val;

        maxSum = Math.max(maxSum , Math.max(case1Sum , Math.max(case2Sum , case3Sum)));

        return Math.max(case2Sum , case3Sum);
    }
}
