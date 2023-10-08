// Path Sum

// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
// A leaf is a node with no children.

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    public boolean dfs(TreeNode root, int targetSum, int currentSum){
        if ( root == null){
            return false;
        }
        currentSum += root.val;
        if(targetSum == currentSum && root.left == null && root.right == null){
            return true;
        }
         
        return dfs(root.left, targetSum, currentSum) || dfs(root.right, targetSum, currentSum);

    }
}

// BFS Queue
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> valQ = new LinkedList<>();

        if(root == null){
            return false;
        }

        nodeQ.offer(root);
        valQ.offer(root.val);

        while(!nodeQ.isEmpty()){
            TreeNode node = nodeQ.poll();
            int temp = valQ.poll();
            if(node.left == null && node.right == null){
                if(temp == targetSum){
                    return true;
                }
                continue;
            }

            if(node.left != null){
                valQ.offer(temp + node.left.val);
                nodeQ.offer(node.left);
            }

            if(node.right != null){
                valQ.offer(temp + node.right.val);
                nodeQ.offer(node.right);
            }

        }


        return false; 
    }
}