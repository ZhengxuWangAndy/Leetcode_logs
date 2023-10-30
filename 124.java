// Binary Tree Maximum Path Sum


// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.


class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        // Recursivly get max contribution to parents
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // calculate left node right path
        int priceNewpath = node.val + leftGain + rightGain;

        // update the max value
        maxSum = Math.max(maxSum, priceNewpath);

        // get back current node's contribution
        return node.val + Math.max(leftGain, rightGain);
    }
}