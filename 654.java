// Maximum Binary Tree

// You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

// Create a root node whose value is the maximum value in nums.
// Recursively build the left subtree on the subarray prefix to the left of the maximum value.
// Recursively build the right subtree on the subarray suffix to the right of the maximum value.
// Return the maximum binary tree built from nums.

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

// recursive way n^2
class Solution {
    public TreeNode recursive(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int maximum = left;
        for(int i = left; i <= right; i++){
            if (nums[i] > nums[maximum]){
                maximum = i;
            }
        }
        TreeNode root = new TreeNode(nums[maximum]);
        root.left = recursive(nums, left, maximum-1);
        root.right = recursive(nums,maximum+1, right);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }
}