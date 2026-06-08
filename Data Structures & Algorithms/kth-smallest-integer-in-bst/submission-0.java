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
    int ans = -1;
    int step = 0;
    private void dfs(TreeNode node, int k){
        if(node == null || step == k) return;
        dfs(node.left, k);
        if(step+1 == k){
            ans = node.val;
            step++;
            return;
        }
        step++;
        dfs(node.right,k);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}